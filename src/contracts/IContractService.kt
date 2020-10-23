package contracts

interface IContractService {
    fun getContracts(): List<Contract>
//    fun getContractsOfUser(user: User): List<Contract>
//    fun getOpenContracts(): List<Contract>
    fun postContract(contract: Contract)
    fun acceptContract(contract: Contract)
    fun rescindContract(contract: Contract)
}
