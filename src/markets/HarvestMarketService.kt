package markets

import contracts.Contract
import contracts.IContractService
import locations.Geolocation
import locations.IGeolocationService
import reviews.IReviewService
import reviews.Review
import harvests.IHarvestService
import users.IUserService
import users.User
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class HarvestMarketService : IMarketService {
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
        return contractService.getContracts().filter { contract -> !isClosedOrExpired(contract) }
    }

    override fun findOpenContractsNearby(user: User, range: Long): List<Contract> {
        val userGeolocation = geolocationService.getGeolocationOfUser(user);
        return contractService.getContracts().filter { contract -> isContractWithinUsersRange(contract, userGeolocation, range) }
    }

    override fun findOpenContractsDuringDateRange(start: Date, end: Date): List<Contract> {
        return contractService.getContracts().filter { contract -> !isClosedOrExpired(contract) }
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isContractWithinUsersRange(contract: Contract, userGeolocation: Geolocation, range: Long): Boolean {
        return contract.location.bounds.any { contractGeolocation -> isWithinRange(userGeolocation, contractGeolocation, range) }
    }

    private fun isWithinRange(source: Geolocation, target: Geolocation, range: Long): Boolean {
        val maxLatitudeRange = source.latitude + range
        val minLatitudeRange = source.latitude - range
        val latitudeRange = minLatitudeRange..maxLatitudeRange

        val maxLongitudeRange = source.longitude + range
        val minLongitudeRange = source.longitude - range
        val longitudeRange = minLongitudeRange..maxLongitudeRange

        return target.latitude in latitudeRange && target.longitude in longitudeRange
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isClosedOrExpired(contract: Contract): Boolean {
        val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
        return now >= contract.closed || now >= contract.expiration
    }
}
