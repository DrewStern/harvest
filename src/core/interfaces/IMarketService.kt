package core.interfaces

import financial.contracts.Contract
import social.users.User
import java.util.*

interface IMarketService {
    fun findOpenContracts(): List<Contract>
    fun findOpenContractsNearby(user: User, range: Long): List<Contract>
    fun findOpenContractsDuringDateRange(start: Date, end: Date): List<Contract>
    //fun findOpenContractsPostedByFriends
    //fun findOpenContractsPostedByPreviousPurchases
}