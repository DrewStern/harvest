package financial.markets

import financial.contracts.Contract
import interfaces.*
import physical.geolocations.Geolocation
import social.reviews.Review
import calendars.DateRange
import calendars.CalendarService
import social.users.User
import social.users.UserService
import java.util.*

class MarketService : IMarketService {
    private val contractService: IContractService
    private val reviewService: IReviewService
    private val geolocationService: IGeolocationService
    private val estateService: IEstateService
    private val calendarService: CalendarService
    private val userService: UserService

    constructor(
        calendarService: CalendarService,
        geolocationService: IGeolocationService,
        userService: UserService,
        estateService: IEstateService,
        contractService: IContractService,
        reviewService: IReviewService
    ) {
        this.contractService = contractService
        this.reviewService = reviewService
        this.geolocationService = geolocationService
        this.estateService = estateService
        this.calendarService = calendarService
        this.userService = userService
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
