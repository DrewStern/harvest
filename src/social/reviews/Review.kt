package social.reviews

import financial.contracts.Contract
import java.util.*

data class Review(
    val id: Int,
    val contract: Contract,
    val posted: Date,
    val text: String,
    val score: Int
)