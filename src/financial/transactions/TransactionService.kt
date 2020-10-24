package financial.transactions

import core.interfaces.IRepository
import core.interfaces.ITransactionService

class TransactionService: ITransactionService {
    private val repository: IRepository<Transaction>

    constructor(repository: IRepository<Transaction>) {
        this.repository = repository
    }

    fun validate(transaction: Transaction): Boolean {
        return transaction.id > 0 && transaction.price > 0
    }
}