package financial.contracts

import social.users.User
import java.util.*

data class ContractUpdate(
    val contractId: Int,
    val changeId: Int,
    val updatedBy: User,
    val updatedAt: Date,
    val status: ContractStatus
)