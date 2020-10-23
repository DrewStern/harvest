package social.messages

import social.users.User

data class Message(
    val id: Int,
    val source: User,
    val target: User,
    val content: String
)