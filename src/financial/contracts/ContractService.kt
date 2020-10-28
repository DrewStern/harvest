package financial.contracts

import core.interfaces.*
import physical.estates.Estate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class ContractService: IContractService {
    private val repository: IRepository<Contract>
    private val contractHistoryService: IContractHistoryService
    private val calendarService: ICalendarService
    private val estateService: IEstateService
    private val harvestService: IHarvestService

    constructor(
        repository: IRepository<Contract>,
        contractHistoryService: IContractHistoryService,
        calendarService: ICalendarService,
        estateService: IEstateService,
        harvestService: IHarvestService
    ) {
        this.repository = repository
        this.contractHistoryService = contractHistoryService
        this.calendarService = calendarService
        this.estateService = estateService
        this.harvestService = harvestService
    }

    override fun getContracts(): List<Contract> {
        return repository.find()
    }

    override fun getOpenContracts(): List<Contract> {
        return getContracts().filter { contract -> isContractOpen(contract) }
    }

    override fun postContract(contract: Contract) {
        if (canBePosted(contract)) {
            repository.save(contract)
        }
    }

    override fun acceptContract(contract: Contract) {
        if (canBeAccepted(contract)) {
            repository.save(contract)
        }
    }

    override fun rescindContract(contract: Contract) {
        if (canBeRescinded(contract)) {
            repository.save(contract)
        }
    }

    override fun expireContract(contract: Contract) {
        if (shouldBeExpired(contract)) {
            repository.save(contract)
        }
    }

    fun isContractOpen(contract: Contract): Boolean {
        return contract.history.updates.last().status == ContractStatus.Open
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun shouldBeExpired(contract: Contract): Boolean {
        val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
        return now >= contract.expiration
    }

    private fun canBePosted(contract: Contract): Boolean {
        val estate = estateService.getEstate(contract.estate.id)
        return validate(contract) && isContractBeingSoldByEstateOwner(contract, estate)
    }

    private fun canBeAccepted(contract: Contract): Boolean {
        return validate(contract)
            && isContractInStage(contract, ContractStatus.Open)
            && !areBuyerAndSellerIdentical(contract)
    }

    private fun canBeRescinded(contract: Contract): Boolean {
        return validate(contract)
            && isContractInStage(contract, ContractStatus.Open)
            && areBuyerAndSellerIdentical(contract)
    }

    private fun isContractInStage(contract: Contract, status: ContractStatus): Boolean {
        return contract.history.updates.last().status.equals(status)
    }

    private fun isContractBeingSoldByEstateOwner(contract: Contract, estate: Estate): Boolean {
        val estateOwnerId = estateService.getOwnerOfEstate(estate).id
        // TODO: if estateOwnerId from above disagrees with the given estate's owner.id, then throw security violation?
        // TODO: assertEquals(estateOwnerId, estate.owner.id)
        return contract.seller.id.equals(estateOwnerId)
    }

    private fun areBuyerAndSellerIdentical(contract: Contract): Boolean {
        val history = contractHistoryService.getHistory(contract)
        val accepted = history.updates.last { update -> update.status.equals(ContractStatus.Accepted) }
        val buyer = accepted.updatedBy
        return buyer.id.equals(contract.seller.id)
    }

    private fun validate(contract: Contract): Boolean {
        return contract.id > 0 && contract.price > 0
    }
}