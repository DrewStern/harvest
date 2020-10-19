package reviews

import contracts.Contract
import java.util.*

data class Review(
    val id: Int,
    val contract: Contract,
    val posted: Date,
    val content: String
)