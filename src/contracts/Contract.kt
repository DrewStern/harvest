package contracts

import harvests.Harvest
import tools.DateTimeRange
import properties.Property
import users.User
import java.util.*

data class Contract(
    val id: Int,
    val seller: User,
    val buyer: User,
    val price: Long,

    val location: Property,
    val harvest: Harvest,

    val posted: Date,
    val closed: Date,
    val expiration: Date,
    val fulfillment: DateTimeRange
)