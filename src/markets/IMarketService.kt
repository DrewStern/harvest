package markets

import contracts.Contract
import reviews.Review
import users.User
import java.util.*

interface IMarketService {
    fun createContract(contract: Contract)
//    fun updateContract(contract: Contract)
//    fun deleteContract(contractId: Int)
//    fun acceptContract(contractId: Int)
//    fun declineContract(contractId: Int)
    fun findOpenContractsNearby(user: User, range: Long): List<Contract>
    fun findOpenContractsDuringTimeframe(start: Date, end: Date): List<Contract>
    fun createReview(review: Review)
}