package financial.contracts

import core.interfaces.IRepository

class ContractRepository: IRepository<Contract> {
    override fun find(): List<Contract> {
        return emptyList()
    }

    override fun find(id: Int): Contract {
        return find().first { contract -> contract.id.equals(id) }
    }

    fun save(contract: Contract, toStatus: ContractStatus): Boolean {
        return true
    }

    override fun save(contract: Contract): Boolean {
        return true
    }
}