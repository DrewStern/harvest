package markets

import contracts.Contract
import contracts.IContractService
import locations.Geolocation
import locations.IGeolocationService
import reviews.IReviewService
import reviews.Review
import harvests.IHarvestService
import tools.DateTimeRange
import users.IUserService
import users.User
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class MarketService : IMarketService {
    private val contractService: IContractService
    private val reviewService: IReviewService
    private val geolocationService: IGeolocationService

    constructor(
        userService: IUserService,
        contractService: IContractService,
        reviewService: IReviewService,
        geolocationService: IGeolocationService,
        harvestService: IHarvestService
    ) {
        this.contractService = contractService
        this.reviewService = reviewService
        this.geolocationService = geolocationService
    }

    override fun createContract(contract: Contract) {
        contractService.postContract(contract)
    }

    override fun createReview(review: Review) {
        reviewService.postReview(review)
    }

    override fun findOpenContracts(): List<Contract> {
        return contractService.getContracts().filter { contract -> isOpen(contract) }
    }

    override fun findOpenContractsNearby(user: User, range: Long): List<Contract> {
        val userGeolocation = geolocationService.getGeolocationOfUser(user);
        return findOpenContracts().filter { contract -> isContractWithinUsersRange(contract, userGeolocation, range) }
    }

    override fun findOpenContractsDuringDateRange(start: Date, end: Date): List<Contract> {
        return findOpenContracts().filter { contract -> isContractWithinUserDateRange(contract, DateTimeRange(start, end))  }
    }

    private fun isContractWithinUserDateRange(contract: Contract, userRange: DateTimeRange): Boolean {
        return userRange.start.before(contract.fulfillment.start) && userRange.end.after(contract.fulfillment.end)
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isContractWithinUsersRange(contract: Contract, userGeolocation: Geolocation, range: Long): Boolean {
        return contract.estate.bounds.any { contractGeolocation -> isWithinRange(userGeolocation, contractGeolocation, range) }
    }

    private fun isWithinRange(source: Geolocation, target: Geolocation, range: Long): Boolean {
        val latitudeRange = (source.latitude - range).rangeTo(source.latitude + range)
        val longitudeRange = (source.longitude - range).rangeTo(source.longitude + range)
        return target.latitude in latitudeRange && target.longitude in longitudeRange
    }

    private fun isOpen(contract: Contract): Boolean {
        return !isClosedOrExpired(contract)
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isClosedOrExpired(contract: Contract): Boolean {
        val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
        return now >= contract.closed || now >= contract.expiration
    }
}
