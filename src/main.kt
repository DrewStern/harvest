import contracts.ContractService
import locations.GeolocationService
import markets.HarvestMarketService
import reviews.ReviewService
import stocks.StockService
import users.UserService

fun main() {
    val stockService = StockService()
    val geolocationService = GeolocationService()
    val reviewService = ReviewService()
    val contractService = ContractService()
    val userService = UserService()
    val harvestMarketService = HarvestMarketService(userService, contractService, reviewService, geolocationService, stockService)
    harvestMarketService.helloWorld()
}



























