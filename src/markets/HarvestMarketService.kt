package markets

import contracts.Contract
import contracts.IContractService
import locations.Geolocation
import locations.IGeolocationService
import reviews.IReviewService
import stocks.IStockService
import users.IUserService
import users.User
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class HarvestMarketService : IMarketService {
    var contractService: IContractService
    var geolocationService: IGeolocationService

    constructor(
        userService: IUserService,
        contractService: IContractService,
        reviewService: IReviewService,
        geolocationService: IGeolocationService,
        stockService: IStockService
    ) {
        this.contractService = contractService
        this.geolocationService = geolocationService
    }

    override fun findOpenContractsNearby(user: User, range: Long): List<Contract> {
        val userGeolocation = geolocationService.getGeolocationOfUser(user);
        return contractService.getContracts().filter { contract -> isWithinUsersRange(contract, userGeolocation, range) }
    }

    override fun findOpenContractsDuringTimeframe(start: Date, end: Date): List<Contract> {
        return contractService.getContracts().filter { contract -> !isClosedOrExpired(contract) }
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isWithinUsersRange(contract: Contract, userGeolocation: Geolocation, range: Long): Boolean {
        val usersMaxLatitudeRange = userGeolocation.latitude + range
        val usersMinLatitudeRange = userGeolocation.latitude - range
        val usersMaxLongitudeRange = userGeolocation.longitude + range
        val usersMinLongitudeRange = userGeolocation.longitude - range
        return contract.location.bounds.any { geolocation ->
            usersMinLatitudeRange <= geolocation.latitude && geolocation.latitude <= usersMaxLatitudeRange &&
            usersMinLongitudeRange <= geolocation.longitude && geolocation.longitude <= usersMaxLongitudeRange
        }
    }

    // TODO: this algorithm sucks but will get switched out for something better eventually
    private fun isClosedOrExpired(contract: Contract): Boolean {
        val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
        return now >= contract.closed || now >= contract.expiration
    }
}
