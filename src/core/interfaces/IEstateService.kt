package core.interfaces

import physical.estates.Estate
import social.users.User

interface IEstateService {

    fun getEstates(): List<Estate>

    fun getEstate(id: Int): Estate

    fun getOwnerOfEstate(estate: Estate): User

    fun postClaimToEstate(estate: Estate)
}