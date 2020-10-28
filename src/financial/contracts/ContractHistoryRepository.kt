package financial.contracts

import core.interfaces.IRepository

class ContractHistoryRepository: IRepository<ContractHistory> {
    override fun find(): List<ContractHistory> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): ContractHistory {
        TODO("Not yet implemented")
    }

    override fun save(item: ContractHistory): Boolean {
        TODO("Not yet implemented")
    }
}