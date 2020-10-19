import contracts.ContractService
import locations.GeolocationService
import markets.HarvestMarketService
import reviews.ReviewService
import stocks.StockService
import users.UserService
import java.sql.Date
import java.time.LocalDate
import java.time.LocalDateTime

fun main() {
    // TODO: DI done right using some fancy technology
    val stockService = StockService()
    val geolocationService = GeolocationService()
    val reviewService = ReviewService()
    val contractService = ContractService()
    val userService = UserService()
    val harvestMarketService = HarvestMarketService(userService, contractService, reviewService, geolocationService, stockService)


    // TODO: move this to a test package
    val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
    val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
    harvestMarketService.findOpenContractsDuringTimeframe(fakeStartDate, fakeEndDate)
}
