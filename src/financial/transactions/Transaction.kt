package financial.transactions

data class Transaction(
    val type: TransactionType,
    val id: Int,
    val price: Long
)