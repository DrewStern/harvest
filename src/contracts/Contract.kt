package contracts

import estates.Estate
import harvests.Harvest
import tools.DateTimeRange
import users.User
import java.util.*

data class Contract(
    val id: Int,
    val seller: User,
    val buyer: User,

    val price: Long, // note that kotlin already supports LongRange, but not DateTimeRange unfortunately
    val estate: Estate,
    val harvest: Harvest,

    val stage: ContractStage,
    val posted: Date,
    val closed: Date,
    val accepted: Date,
    val expiration: Date?, // maybe allow an expiration date, but not required
    val fulfillment: DateTimeRange // allow for a range of fulfillment dates
)