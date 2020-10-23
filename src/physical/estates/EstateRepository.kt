package physical.estates

import bases.Repository

class EstateRepository: Repository<Estate>() {
    override fun find(): List<Estate> {
        return getFakeEstates()
    }

    override fun find(id: Int): Estate {
        return getFakeEstates().first()
    }

    override fun save(item: Estate): Boolean {
        TODO("Not yet implemented")
    }

    private fun getFakeEstates(): List<Estate> {
        return emptyList()
    }
}