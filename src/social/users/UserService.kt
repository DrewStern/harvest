package social.users

import physical.geolocations.Geolocation
import core.interfaces.IUserService

class UserService: IUserService {
    private val repository: UserRepository

    constructor(repository: UserRepository) {
        this.repository = repository
    }

    override fun getUsers(): List<User> {
        return repository.find()
    }

    override fun getGeolocation(user: User): Geolocation {
        return getFakeGeolocation()
    }

    private fun getFakeGeolocation(): Geolocation {
        return Geolocation(1, 123.0, 234.5)
    }
}