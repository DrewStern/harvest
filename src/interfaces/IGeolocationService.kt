package interfaces

import geolocations.Geolocation
import users.User

interface IGeolocationService {
    fun getGeolocationOfUser(user: User): Geolocation
//    fun getGeolocationOfContract(contract: Contract): Geolocation

    fun isWithinRange(source: Geolocation, target: Geolocation, range: Long): Boolean
}