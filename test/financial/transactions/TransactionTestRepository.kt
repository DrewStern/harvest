package financial.transactions

import core.interfaces.IRepository

class TransactionTestRepository: IRepository<Transaction> {
    override fun find(): List<Transaction> {
        return emptyList()
    }

    override fun find(id: Int): Transaction {
        TODO("Not yet implemented")
    }

    override fun save(item: Transaction): Boolean {
        TODO("Not yet implemented")
    }
}