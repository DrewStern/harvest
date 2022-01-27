package financial.contracts

import physical.estates.Estate
import physical.harvests.Harvest
import social.users.User
import java.util.*

data class Contract(
    val id: Int,
    val issuer: User,
    val price: Long, // note that kotlin already supports LongRange, but not DateTimeRange unfortunately
    val estate: Estate,
    val harvest: Harvest,
    val expiration: Date
)