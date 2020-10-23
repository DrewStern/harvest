package harvests

import repositories.Repository

class HarvestRepository: Repository<Harvest>() {
    override fun find(): List<Harvest> {
        TODO("Not yet implemented")
    }

    override fun save(item: Harvest): Boolean {
        TODO("Not yet implemented")
    }
}