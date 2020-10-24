package core.interfaces

import financial.contracts.Contract
import social.reviews.Review
import social.users.User
import java.util.*

interface IMarketService {
    fun createContract(contract: Contract)
//    fun updateContract(contract: Contract)
//    fun deleteContract(contractId: Int)
//    fun acceptContract(contractId: Int)
//    fun declineContract(contractId: Int)
    fun findOpenContracts(): List<Contract>
    fun findOpenContractsNearby(user: User, range: Long): List<Contract>
    fun findOpenContractsDuringDateRange(start: Date, end: Date): List<Contract>
    fun createReview(review: Review)
}