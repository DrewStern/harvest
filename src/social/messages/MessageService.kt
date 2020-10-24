package social.messages

import core.interfaces.IMessageService

class MessageService: IMessageService {
    val repository: MessageRepository
    constructor(repository: MessageRepository) {
        this.repository = repository
    }
}