package transactions

import transactions.TransactionType

data class Transaction(
    val type: TransactionType,
    val price: Long
)