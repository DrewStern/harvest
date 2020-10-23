package contracts

class ContractService: IContractService {
    private val repository: ContractRepository

    constructor(repository: ContractRepository) {
        this.repository = repository
    }

    override fun getContracts(): List<Contract> {
        return repository.find()
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

    private fun canBePosted(contract: Contract): Boolean {
        return validate(contract) && contract.seller.equals(contract.estate.owner)
    }

    private fun canBeAccepted(contract: Contract): Boolean {
        return validate(contract) && !contract.seller.equals(contract.buyer) && contract.stage.equals(ContractStage.Posted)
    }

    private fun canBeRescinded(contract: Contract): Boolean {
        return validate(contract) && contract.seller.equals(contract.buyer) && contract.stage.equals(ContractStage.Posted)
    }

    private fun validate(contract: Contract): Boolean {
        return contract.id > 0 && contract.price > 0
    }
}