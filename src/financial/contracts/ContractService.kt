package financial.contracts

import physical.estates.Estate
import physical.estates.EstateService
import physical.harvests.HarvestService
import core.interfaces.IContractService
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class ContractService: IContractService {
    private val repository: ContractRepository
    private val estateService: EstateService
    private val harvestService: HarvestService

    constructor(repository: ContractRepository, estateService: EstateService, harvestService: HarvestService) {
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
            repository.save(contract, ContractStage.Posted)
        }
    }

    // TODO: need to check that the contract is still open
    override fun acceptContract(contract: Contract) {
        if (canBeAccepted(contract)) {
            repository.save(contract, ContractStage.Accepted)
        }
    }

    // TODO: need to check that the contract is still open
    override fun rescindContract(contract: Contract) {
        if (canBeRescinded(contract)) {
            repository.save(contract, ContractStage.Rescinded)
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
        return validate(contract) && !areBuyerAndSellerIdentical(contract) && isContractInStage(contract,
            ContractStage.Posted
        )
    }

    private fun canBeRescinded(contract: Contract): Boolean {
        return validate(contract) && areBuyerAndSellerIdentical(contract) && isContractInStage(contract,
            ContractStage.Posted
        )
    }

    private fun isContractInStage(contract: Contract, stage: ContractStage): Boolean {
        return contract.stage.equals(stage)
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