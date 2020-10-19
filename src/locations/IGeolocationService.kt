package locations

import contracts.Contract
import users.User

interface IGeolocationService {
    fun getGeolocationOfUser(user: User): Geolocation
//    fun getGeolocationOfContract(contract: Contract): Geolocation
}