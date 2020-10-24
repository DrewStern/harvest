package financial.markets

import core.interfaces.*
import financial.contracts.Contract
import physical.geolocations.Geolocation
import social.calendars.DateRange
import social.reviews.Review
import social.users.User
import java.util.*

class MarketService : IMarketService {
    private val contractService: IContractService
    private val reviewService: IReviewService
    private val geolocationService: IGeolocationService
    private val estateService: IEstateService
    private val calendarService: ICalendarService
    private val userService: IUserService
    private val messageService: IMessageService
    private val transactionService: ITransactionService

    constructor(
        calendarService: ICalendarService,
        geolocationService: IGeolocationService,
        userService: IUserService,
        estateService: IEstateService,
        contractService: IContractService,
        reviewService: IReviewService,
        messageService: IMessageService,
        transactionService: ITransactionService
    ) {
        this.contractService = contractService
        this.reviewService = reviewService
        this.geolocationService = geolocationService
        this.estateService = estateService
        this.calendarService = calendarService
        this.userService = userService
        this.messageService = messageService
        this.transactionService = transactionService
    }

    override fun createContract(contract: Contract) {
        contractService.postContract(contract)
    }

    override fun createReview(review: Review) {
        reviewService.postReview(review)
    }

    override fun findOpenContracts(): List<Contract> {
        return contractService.getOpenContracts()
    }

    override fun findOpenContractsNearby(user: User, range: Long): List<Contract> {
        val userGeolocation = userService.getGeolocation(user)

        return findOpenContracts().filter { contract ->
            isContractWithinUsersRange(contract, userGeolocation, range) }
    }

    override fun findOpenContractsDuringDateRange(start: Date, end: Date): List<Contract> {
        val userDateRange = DateRange(start, end)
        return findOpenContracts().filter { contract ->
            calendarService.isStrictlyContainedInRange(contract.fulfillment, userDateRange)  }
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isContractWithinUsersRange(contract: Contract, userGeolocation: Geolocation, range: Long): Boolean {
        return contract.estate.bounds.any { contractGeolocation ->
            geolocationService.isWithinRange(userGeolocation, contractGeolocation, range) }
    }
}
