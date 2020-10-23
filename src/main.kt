import contracts.ContractRepository
import contracts.ContractService
import estates.EstateRepository
import estates.EstateService
import harvests.HarvestRepository
import geolocations.GeolocationService
import markets.MarketService
import reviews.ReviewService
import harvests.HarvestService
import messages.MessageRepository
import messages.MessageService
import reviews.ReviewRepository
import tools.DateTimeService
import transactions.TransactionRepository
import transactions.TransactionService
import users.UserRepository
import users.UserService
import java.sql.Date
import java.time.LocalDate

fun main() {
    // TODO: DI done right using some fancy technology
    val dateTimeService = DateTimeService()
    val geolocationService = GeolocationService()
    val userService = UserService(UserRepository())

    val estateService = EstateService(EstateRepository())
    val harvestService = HarvestService(HarvestRepository())
    val contractService = ContractService(ContractRepository(), estateService, harvestService)

    val transactionService = TransactionService(TransactionRepository())
    val messageService = MessageService(MessageRepository())
    val reviewService = ReviewService(ReviewRepository())
    val marketService = MarketService(geolocationService, contractService, reviewService, estateService, dateTimeService)

    // TODO: move this to a test package
    val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
    val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
    marketService.findOpenContractsDuringDateRange(fakeStartDate, fakeEndDate)

    print("hello world")
}
