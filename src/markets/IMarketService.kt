package markets

import contracts.Contract
import users.User
import java.util.*

interface IMarketService {
    fun findOpenContractsNearby(user: User): List<Contract>
    fun findOpenContractsDuringTimeframe(start: Date, end: Date): List<Contract>
}