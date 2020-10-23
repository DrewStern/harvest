package social.messages

import interfaces.IMessageService

class MessageService: IMessageService {
    val repository: MessageRepository
    constructor(repository: MessageRepository) {
        this.repository = repository
    }
}