import contracts.ContractRepository
import contracts.ContractService
import harvests.HarvestRepository
import locations.GeolocationService
import markets.MarketService
import reviews.ReviewService
import harvests.HarvestService
import reviews.ReviewRepository
import transactions.TransactionRepository
import transactions.TransactionService
import users.UserRepository
import users.UserService
import java.sql.Date
import java.time.LocalDate

fun main() {
    // TODO: DI done right using some fancy technology
    val userService = UserService(UserRepository())
    val contractService = ContractService(ContractRepository())
    val reviewService = ReviewService(ReviewRepository())
    val geolocationService = GeolocationService()
    val harvestService = HarvestService(HarvestRepository())
    val transactionService = TransactionService(TransactionRepository())
    val marketService = MarketService(userService, contractService, reviewService, geolocationService, harvestService)

    // TODO: move this to a test package
    val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
    val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
    marketService.findOpenContractsDuringDateRange(fakeStartDate, fakeEndDate)

    print("hello world")
}
