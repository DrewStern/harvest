package physical.estates

import core.interfaces.IRepository

class EstateRepository: IRepository<Estate> {
    override fun find(): List<Estate> {
        return getFakeEstates()
    }

    override fun find(id: Int): Estate {
        return getFakeEstates().first { estate -> estate.id.equals(id) }
    }

    override fun save(item: Estate): Boolean {
        TODO("Not yet implemented")
    }

    private fun getFakeEstates(): List<Estate> {
        return emptyList()
    }
}