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
    val userService = UserService()
    val contractService = ContractService()
    val reviewService = ReviewService()
    val geolocationService = GeolocationService()
    val harvestService = HarvestService()
    val harvestMarketService = HarvestMarketService(userService, contractService, reviewService, geolocationService, harvestService)

    // TODO: move this to a test package
    val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
    val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
    harvestMarketService.findOpenContractsDuringDateRange(fakeStartDate, fakeEndDate)
}
