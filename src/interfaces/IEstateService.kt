package interfaces

import estates.Estate
import users.User

interface IEstateService {

    fun getEstates(): List<Estate>

    fun getEstate(id: Int): Estate

    fun getOwnerOfEstate(estate: Estate): User

    fun postOwnershipOfEstate(user: User, estate: Estate)
}