package physical.estates

import core.interfaces.IEstateService
import core.interfaces.IRepository
import social.users.User

class EstateService: IEstateService {
    private val repository: IRepository<Estate>

    constructor(repository: IRepository<Estate>) {
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

    override fun postClaimToEstate(estate: Estate) {
        if (canClaimEstate(estate)) {
            repository.save(estate)
        }
    }

    private fun canClaimEstate(estate: Estate): Boolean {
        return true
    }

    private fun validate(): Boolean {
        return true
    }
}