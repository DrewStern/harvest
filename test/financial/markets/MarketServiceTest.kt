package financial.markets

import financial.contracts.ContractService
import financial.contracts.ContractTestRepository
import financial.transactions.TransactionService
import financial.transactions.TransactionTestRepository
import physical.estates.EstateService
import physical.estates.EstateTestRepository
import physical.geolocations.GeolocationService
import physical.geolocations.GeolocationTestRepository
import physical.harvests.HarvestService
import physical.harvests.HarvestTestRepository
import social.calendars.CalendarService
import social.calendars.CalendarTestRepository
import social.messages.MessageService
import social.messages.MessageTestRepository
import social.reviews.ReviewService
import social.reviews.ReviewTestRepository
import social.users.UserService
import social.users.UserTestRepository
import java.sql.Date
import java.time.LocalDate

class MarketServiceTest {
//    @Test
    fun givenSomeDateRange_whenMarketIsQueried_thenMatchingContractsShouldBeFound() {
        // physical packages
        val geolocationService = GeolocationService(GeolocationTestRepository())
        val estateService = EstateService(EstateTestRepository())
        val harvestService = HarvestService(HarvestTestRepository())

        // social packages
        val userService = UserService(UserTestRepository())
        val calendarService = CalendarService(CalendarTestRepository())
        val messageService = MessageService(MessageTestRepository())
        val reviewService = ReviewService(ReviewTestRepository())

        // financial packages
        val contractService = ContractService(ContractTestRepository(), estateService, harvestService)
        val transactionService = TransactionService(TransactionTestRepository())

        val marketService = MarketService(calendarService, geolocationService, userService, estateService, contractService, reviewService, messageService, transactionService)


        val fakeStartDate = Date.valueOf(LocalDate.now().minusYears(1))
        val fakeEndDate = Date.valueOf(LocalDate.now().plusYears(1))
        val expected =
        val actual = marketService.findOpenContractsDuringDateRange(fakeStartDate, fakeEndDate)
    }
}