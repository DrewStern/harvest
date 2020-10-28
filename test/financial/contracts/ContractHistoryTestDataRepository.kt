package financial.contracts

import core.interfaces.IRepository
import social.users.Privilege
import social.users.User
import java.util.*

class ContractHistoryTestDataRepository: IRepository<ContractHistory> {

    override fun find(): List<ContractHistory> {
        return listOf(getPostedThenExpiredContractHistory(1), getPostedThenRescindedContractHistory(2), getPostedThenAcceptedContractHistory(3))
    }

    override fun find(id: Int): ContractHistory {
        TODO("Not yet implemented")
    }

    override fun save(item: ContractHistory): Boolean {
        TODO("Not yet implemented")
    }

    private fun getPostedThenExpiredContractHistory(contractId: Int): ContractHistory {
        val user = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val postedChange = ContractUpdate(contractId, 1, user, Date(), ContractStatus.Open)
        val rescindedChange = ContractUpdate(contractId, 2, user, Date(), ContractStatus.Expired)
        return ContractHistory(contractId, listOf(postedChange, rescindedChange))
    }

    private fun getPostedThenRescindedContractHistory(contractId: Int): ContractHistory {
        val user = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val postedChange = ContractUpdate(contractId, 1, user, Date(), ContractStatus.Open)
        val rescindedChange = ContractUpdate(contractId, 2, user, Date(), ContractStatus.Rescinded)
        return ContractHistory(contractId, listOf(postedChange, rescindedChange))
    }

    private fun getPostedThenAcceptedContractHistory(contractId: Int): ContractHistory {
        val seller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val buyer = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val postedChange = ContractUpdate(contractId, 1, seller, Date(), ContractStatus.Open)
        val acceptedChange = ContractUpdate(contractId, 2, buyer, Date(), ContractStatus.Accepted)
        return ContractHistory(contractId, listOf(postedChange, acceptedChange))
    }
}