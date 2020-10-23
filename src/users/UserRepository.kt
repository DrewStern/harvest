package users

import bases.Repository

class UserRepository: Repository<User>() {
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