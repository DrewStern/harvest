package physical.harvests

import core.interfaces.IHarvestService

class HarvestService: IHarvestService {
    private val repository: HarvestRepository

    constructor(repository: HarvestRepository) {
        this.repository = repository
    }

    override fun getProofOfStock(): Harvest {
        TODO("Not yet implemented")
    }
}