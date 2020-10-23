package estates

import users.User

class EstateService: IEstateService {
    override fun getOwnerOfProperty(estate: Estate): User {
        TODO("Not yet implemented")
    }

    override fun postOwnershipOfProperty(user: User, estate: Estate) {
        TODO("Not yet implemented")
    }
}