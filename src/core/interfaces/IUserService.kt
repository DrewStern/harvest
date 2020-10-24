package core.interfaces

import physical.geolocations.Geolocation
import social.users.User

interface IUserService {

    fun getUsers(): List<User>
//    fun getUser(userId: Int)
//    fun createUser(user: User)
//    fun updateUser(user: User)
//    fun deleteUser(user: User)
//
//    fun postClaimOfLandOwnership(land: Land)
    fun getGeolocation(user: User): Geolocation
}