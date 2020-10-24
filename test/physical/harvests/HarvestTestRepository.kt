package physical.harvests

import core.interfaces.IRepository

class HarvestTestRepository: IRepository<Harvest> {
    override fun find(): List<Harvest> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Harvest {
        TODO("Not yet implemented")
    }

    override fun save(item: Harvest): Boolean {
        TODO("Not yet implemented")
    }
}