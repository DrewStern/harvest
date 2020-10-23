package users

import interfaces.IUserService

class UserService: IUserService {
    private val repository: UserRepository

    constructor(repository: UserRepository) {
        this.repository = repository
    }

    override fun getUsers(): List<User> {
        return repository.find()
    }
}