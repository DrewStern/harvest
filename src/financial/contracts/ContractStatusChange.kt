package financial.contracts

import social.users.User
import java.util.*

data class ContractStatusChange(
    val contractId: Int,
    val updatedBy: User,
    val updatedAt: Date,
    val status: ContractStatus
)