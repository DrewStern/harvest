package interfaces

import harvests.Harvest

interface IHarvestService {
    fun getProofOfStock(): Harvest
//    fun postProofOfStock(stock: Stock)
//    fun postRemovalOfStock(stock: Stock)
}