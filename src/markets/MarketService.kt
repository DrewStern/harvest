package markets

import contracts.Contract
import interfaces.*
import geolocations.Geolocation
import reviews.Review
import tools.DateTimeRange
import tools.DateTimeService
import users.User
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class MarketService : IMarketService {
    private val contractService: IContractService
    private val reviewService: IReviewService
    private val geolocationService: IGeolocationService
    private val estateService: IEstateService
    private val dateTimeService: DateTimeService

    constructor(
        geolocationService: IGeolocationService,
        contractService: IContractService,
        reviewService: IReviewService,
        estateService: IEstateService,
        dateTimeService: DateTimeService
    ) {
        this.contractService = contractService
        this.reviewService = reviewService
        this.geolocationService = geolocationService
        this.estateService = estateService
        this.dateTimeService = dateTimeService
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
        val userGeolocation = geolocationService.getGeolocationOfUser(user);
        return findOpenContracts().filter { contract ->
            isContractWithinUsersRange(contract, userGeolocation, range) }
    }

    override fun findOpenContractsDuringDateRange(start: Date, end: Date): List<Contract> {
        return findOpenContracts().filter { contract ->
            dateTimeService.isContractWithinUserDateRange(contract, DateTimeRange(start, end))  }
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isContractWithinUsersRange(contract: Contract, userGeolocation: Geolocation, range: Long): Boolean {
        return contract.estate.bounds.any { contractGeolocation ->
            geolocationService.isWithinRange(userGeolocation, contractGeolocation, range) }
    }
}
