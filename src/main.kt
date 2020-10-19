import contracts.ContractService
import locations.GeolocationService
import markets.HarvestMarketService
import reviews.ReviewService
import harvests.HarvestService
import users.UserService
import java.sql.Date
import java.time.LocalDate

fun main() {
    // TODO: DI done right using some fancy technology
    val harvestService = HarvestService()
    val geolocationService = GeolocationService()
    val reviewService = ReviewService()
    val contractService = ContractService()
    val userService = UserService()
    val harvestMarketService = HarvestMarketService(userService, contractService, reviewService, geolocationService, harvestService)


    // TODO: move this to a test package
    val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
    val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
    harvestMarketService.findOpenContractsDuringDateRange(fakeStartDate, fakeEndDate)
}
