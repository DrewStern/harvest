package social.users

import core.interfaces.IRepository
import physical.geolocations.Geolocation
import core.interfaces.IUserService

class UserService: IUserService {
    private val repository: IRepository<User>

    constructor(repository: IRepository<User>) {
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