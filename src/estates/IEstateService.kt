package estates

import users.User

interface IEstateService {
    fun getOwnerOfProperty(estate: Estate): User

    fun postOwnershipOfProperty(user: User, estate: Estate)
}