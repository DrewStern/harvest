package users

import properties.Property
import java.util.*

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val timezone: TimeZone,
    val properties: List<Property>?,
    val role: Privilege
)

// alphabetical order
enum class Privilege {
    Admin,
    Consumer,
    Guest,
    Provider
}
