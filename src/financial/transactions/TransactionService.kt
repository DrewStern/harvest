package financial.transactions

import core.interfaces.ITransactionService

class TransactionService: ITransactionService {
    private val repository: TransactionRepository

    constructor(repository: TransactionRepository) {
        this.repository = repository
    }

    fun validate(transaction: Transaction): Boolean {
        return transaction.id > 0 && transaction.price > 0
    }
}