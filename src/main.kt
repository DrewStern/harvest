import financial.contracts.ContractRepository
import financial.contracts.ContractService
import financial.markets.MarketService
import financial.transactions.TransactionRepository
import financial.transactions.TransactionService
import physical.estates.EstateRepository
import physical.estates.EstateService
import physical.geolocations.GeolocationRepository
import physical.geolocations.GeolocationService
import physical.harvests.HarvestRepository
import physical.harvests.HarvestService
import core.calendars.CalendarRepository
import core.calendars.CalendarService
import social.messages.MessageRepository
import social.messages.MessageService
import social.reviews.ReviewRepository
import social.reviews.ReviewService
import social.users.UserRepository
import social.users.UserService

fun main() {
    // physical packages
    val geolocationService = GeolocationService(GeolocationRepository())
    val estateService = EstateService(EstateRepository())
    val harvestService = HarvestService(HarvestRepository())

    // social packages
    val userService = UserService(UserRepository())
    val calendarService = CalendarService(CalendarRepository())
    val messageService = MessageService(MessageRepository())
    val reviewService = ReviewService(ReviewRepository())

    // financial packages
    val contractService = ContractService(ContractRepository(), estateService, harvestService)
    val transactionService = TransactionService(TransactionRepository())

    val marketService = MarketService(calendarService, geolocationService, userService, estateService, contractService, reviewService, messageService, transactionService)

    print("hello world")
}
