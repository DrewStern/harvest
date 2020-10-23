package transactions

import bases.Repository

class TransactionRepository: Repository<Transaction>() {
    override fun find(): List<Transaction> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Transaction {
        TODO("Not yet implemented")
    }

    override fun save(item: Transaction): Boolean {
        TODO("Not yet implemented")
    }
}