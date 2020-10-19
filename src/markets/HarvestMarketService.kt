package markets

import locations.IGeolocationService
import stocks.IStockService
import contracts.Contract
import contracts.IContractService
import reviews.IReviewService
import users.IUserService
import users.User
import java.util.*

class HarvestMarketService : IMarketService {
    constructor(
        userService: IUserService,
        contractService: IContractService,
        reviewService: IReviewService,
        geolocationService: IGeolocationService,
        stockService: IStockService
    ) {
        println("HarvestMarketService")
    }

    fun helloWorld() {
        println("Hello World!")
    }

    override fun findOpenContractsNearby(user: User): List<Contract> {
        TODO("Not yet implemented")
    }

    override fun findOpenContractsDuringTimeframe(start: Date, end: Date): List<Contract> {
        TODO("Not yet implemented")
    }
}
