package financial.contracts

import core.interfaces.IContractService
import core.interfaces.IEstateService
import core.interfaces.IHarvestService
import core.interfaces.IRepository
import physical.estates.Estate
import core.calendars.DateRange
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class ContractService: IContractService {
    private val repository: IRepository<Contract>
    private val estateService: IEstateService
    private val harvestService: IHarvestService

    constructor(repository: IRepository<Contract>, estateService: IEstateService, harvestService: IHarvestService) {
        this.repository = repository
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

    fun isContractOpen(contract: Contract): Boolean {
        return !isClosedOrExpired(contract)
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isClosedOrExpired(contract: Contract): Boolean {
        val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
        return now >= contract.closed || now >= contract.expiration
    }

    private fun canBePosted(contract: Contract): Boolean {
        val estate = estateService.getEstate(contract.estate.id)
        return validate(contract) && isContractBeingSoldByEstateOwner(contract, estate)
    }

    private fun canBeAccepted(contract: Contract): Boolean {
        return validate(contract)
            && isOrderedCorrectly(contract.fulfillment)
            && !areBuyerAndSellerIdentical(contract)
            && isContractInStage(contract, ContractStatus.Posted)
    }

    private fun canBeRescinded(contract: Contract): Boolean {
        return validate(contract)
            && areBuyerAndSellerIdentical(contract)
            && isContractInStage(contract, ContractStatus.Posted)
    }

    private fun isOrderedCorrectly(fulfillment: DateRange): Boolean {
        return fulfillment.start.before(fulfillment.end)
    }

    private fun isContractInStage(contract: Contract, status: ContractStatus): Boolean {
        return contract.history.changes.last().status.equals(status)
    }

    private fun isContractBeingSoldByEstateOwner(contract: Contract, estate: Estate): Boolean {
        val estateOwnerId = estateService.getOwnerOfEstate(estate).id
        // TODO: if estateOwnerId from above disagrees with the given estate's owner.id, then throw security violation?
        // TODO: assertEquals(estateOwnerId, estate.owner.id)
        return contract.seller.id.equals(estateOwnerId)
    }

    private fun areBuyerAndSellerIdentical(contract: Contract): Boolean {
        return contract.buyer.id.equals(contract.seller.id)
    }

    private fun validate(contract: Contract): Boolean {
        return contract.id > 0 && contract.price > 0
    }
}