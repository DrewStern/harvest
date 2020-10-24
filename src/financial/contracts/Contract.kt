package financial.contracts

import physical.estates.Estate
import physical.harvests.Harvest
import core.calendars.DateRange
import social.users.User
import java.util.*

data class Contract(
    val id: Int,
    val seller: User,
    val buyer: User,

    val price: Long, // note that kotlin already supports LongRange, but not DateTimeRange unfortunately
    val estate: Estate,
    val harvest: Harvest,

    var stage: ContractStage,
    val posted: Date,
    val closed: Date,
    val accepted: Date,
    val expiration: Date?, // maybe allow an expiration date, but not required
    val fulfillment: DateRange // allow for a range of fulfillment dates
)