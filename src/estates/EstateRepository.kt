package estates

import repositories.Repository

class EstateRepository: Repository<Estate>() {
    override fun find(): List<Estate> {
        TODO("Not yet implemented")
    }

    override fun save(item: Estate): Boolean {
        TODO("Not yet implemented")
    }
}