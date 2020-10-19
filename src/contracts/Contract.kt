package contracts

import tools.DateTimeRange
import locations.Land
import users.User
import java.util.*

data class Contract(
    val id: Int,
    val seller: User,
    val buyer: User,
    val price: Long,
    val location: Land,

    val posted: Date,
    val closed: Date,
    val expiration: Date,
    val fulfillment: DateTimeRange
)