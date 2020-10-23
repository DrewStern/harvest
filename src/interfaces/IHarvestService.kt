package interfaces

import physical.harvests.Harvest

interface IHarvestService {
    fun getProofOfStock(): Harvest
//    fun postProofOfStock(stock: Stock)
//    fun postRemovalOfStock(stock: Stock)
}