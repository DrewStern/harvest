package social.messages

import bases.Repository

class MessageRepository: Repository<Message>() {
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