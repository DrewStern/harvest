package social.users

import physical.estates.Estate
import java.util.*

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val timezone: TimeZone,
    val estates: List<Estate>,
    val role: Privilege,
    val email: String,
    val phone: String
//    val paymentMethods: List<PaymentMethod>
)