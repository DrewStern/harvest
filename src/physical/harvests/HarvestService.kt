package physical.harvests

import core.interfaces.IHarvestService
import core.interfaces.IRepository

class HarvestService: IHarvestService {
    private val repository: IRepository<Harvest>

    constructor(repository: IRepository<Harvest>) {
        this.repository = repository
    }

    override fun getProofOfStock(): Harvest {
        TODO("Not yet implemented")
    }
}