package social.messages

import core.interfaces.IMessageService
import core.interfaces.IRepository

class MessageService: IMessageService {
    val repository: IRepository<Message>
    constructor(repository: IRepository<Message>) {
        this.repository = repository
    }
}