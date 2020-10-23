package physical.estates

import interfaces.IEstateService
import social.users.User

class EstateService: IEstateService {
    private val repository: EstateRepository

    constructor(repository: EstateRepository) {
        this.repository = repository
    }

    override fun getEstates(): List<Estate> {
        return repository.find()
    }

    override fun getEstate(id: Int): Estate {
        return repository.find(id)
    }

    override fun getOwnerOfEstate(estate: Estate): User {
        TODO("Not yet implemented")
    }

    override fun postOwnershipOfEstate(user: User, estate: Estate) {
        TODO("Not yet implemented")
    }
}