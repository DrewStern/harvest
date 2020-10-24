package social.users

import core.interfaces.IRepository

class UserRepository: IRepository<User> {
    override fun find(): List<User> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): User {
        TODO("Not yet implemented")
    }

    override fun save(item: User): Boolean {
        TODO("Not yet implemented")
    }
}