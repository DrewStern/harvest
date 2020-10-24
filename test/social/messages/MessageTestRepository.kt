package social.messages

import core.interfaces.IRepository

class MessageTestRepository: IRepository<Message> {
    override fun find(): List<Message> {
        return emptyList()
    }

    override fun find(id: Int): Message {
        TODO("Not yet implemented")
    }

    override fun save(item: Message): Boolean {
        TODO("Not yet implemented")
    }
}