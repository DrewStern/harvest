package users

import locations.Land
import java.util.*

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val timezone: TimeZone,
    val lands: List<Land>?
)