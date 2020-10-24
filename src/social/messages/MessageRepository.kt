package social.messages

import core.interfaces.IRepository

class MessageRepository: IRepository<Message> {
    override fun find(): List<Message> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Message {
        TODO("Not yet implemented")
    }

    override fun save(item: Message): Boolean {
        TODO("Not yet implemented")
    }
}