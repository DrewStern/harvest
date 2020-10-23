import financial.contracts.ContractRepository
import financial.contracts.ContractService
import physical.estates.EstateRepository
import physical.estates.EstateService
import physical.geolocations.GeolocationRepository
import physical.harvests.HarvestRepository
import physical.geolocations.GeolocationService
import financial.markets.MarketService
import social.reviews.ReviewService
import physical.harvests.HarvestService
import social.messages.MessageRepository
import social.messages.MessageService
import social.reviews.ReviewRepository
import calendars.CalendarService
import financial.transactions.TransactionRepository
import financial.transactions.TransactionService
import social.users.UserRepository
import social.users.UserService
import java.sql.Date
import java.time.LocalDate

fun main() {
    // TODO: DI done right using some fancy technology
    val calendarService = CalendarService()
    val geolocationService = GeolocationService(GeolocationRepository())

    val userService = UserService(UserRepository())
    val estateService = EstateService(EstateRepository())
    val harvestService =
        HarvestService(HarvestRepository())

    val contractService = ContractService(
        ContractRepository(),
        estateService,
        harvestService
    )
    val transactionService = TransactionService(TransactionRepository())
    
    val messageService = MessageService(MessageRepository())
    val reviewService = ReviewService(ReviewRepository())

    val marketService = MarketService(
        calendarService,
        geolocationService,
        userService,
        estateService,
        contractService,
        reviewService
    )

    // TODO: move this to a test package
    val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
    val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
    marketService.findOpenContractsDuringDateRange(fakeStartDate, fakeEndDate)

    print("hello world")
}
