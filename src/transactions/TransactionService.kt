package transactions

class TransactionService: ITransactionService {
    private val repository: TransactionRepository
    constructor(repository: TransactionRepository) {
        this.repository = repository
    }
}