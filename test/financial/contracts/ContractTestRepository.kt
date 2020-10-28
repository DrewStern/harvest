package financial.contracts

import core.interfaces.IRepository
import physical.estates.Estate
import physical.geolocations.Geolocation
import physical.harvests.Harvest
import physical.harvests.HarvestType
import social.users.Privilege
import social.users.User
import java.util.*

class ContractTestRepository: IRepository<Contract> {
    private val data: List<Contract>

    constructor() {
        data = listOf(getPostedThenExpiredContract(), getPostedThenRescindedContract(), getPostedThenAcceptedContract())
    }

    override fun find(): List<Contract> {
        return data
    }

    override fun find(id: Int): Contract {
        return data.first { contract -> contract.details.contractId.equals(id) }
    }

    override fun save(item: Contract): Boolean {
        TODO("Not yet implemented")
    }

    private fun getPostedThenExpiredContract(): Contract {
        val fakeContractId = 1
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeEstate = Estate(1, fakeSeller, fakeBounds, 100)
        val fakeHarvest = Harvest(1, HarvestType.Deer, 2)
        val fakeDetails = ContractDetails(fakeContractId, fakePrice, fakeEstate, fakeHarvest)
        val fakeHistory = ContractStatusHistory(fakeContractId, getPostedThenExpiredContractHistory(fakeContractId, fakeSeller))
        return Contract(fakeDetails, fakeHistory)
    }

    private fun getPostedThenExpiredContractHistory(contractId: Int, user: User): List<ContractStatusChange> {
        val postedChange = ContractStatusChange(contractId, user, Date(), ContractStatus.Posted)
        val rescindedChange = ContractStatusChange(contractId, user, Date(), ContractStatus.Expired)
        return listOf(postedChange, rescindedChange)
    }

    private fun getPostedThenRescindedContract(): Contract {
        val fakeContractId = 2
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeEstate = Estate(1, fakeSeller, fakeBounds, 100)
        val fakeHarvest = Harvest(1, HarvestType.Deer, 2)
        val fakeDetails = ContractDetails(fakeContractId, fakePrice, fakeEstate, fakeHarvest)
        val fakeHistory = ContractStatusHistory(fakeContractId, getPostedThenRescindedContractHistory(fakeContractId, fakeSeller))
        return Contract(fakeDetails, fakeHistory)
    }

    private fun getPostedThenRescindedContractHistory(contractId: Int, user: User): List<ContractStatusChange> {
        val postedChange = ContractStatusChange(contractId, user, Date(), ContractStatus.Posted)
        val rescindedChange = ContractStatusChange(contractId, user, Date(), ContractStatus.Rescinded)
        return listOf(postedChange, rescindedChange)
    }

    private fun getPostedThenAcceptedContract(): Contract {
        val fakeContractId = 3
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val fakeBuyer = User(2, "Jon", "Bargiel", TimeZone.getDefault(), emptyList(), Privilege.Guest, "fake@fake", "123-456-7890")
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeEstate = Estate(1, fakeSeller, fakeBounds, 100)
        val fakeHarvest = Harvest(1, HarvestType.Deer, 2)
        val fakeDetails = ContractDetails(fakeContractId, fakePrice, fakeEstate, fakeHarvest)
        val fakeHistory = ContractStatusHistory(fakeContractId, getPostedThenAcceptedContractHistory(fakeContractId, fakeSeller, fakeBuyer))
        return Contract(fakeDetails, fakeHistory)
    }

    private fun getPostedThenAcceptedContractHistory(contractId: Int, seller: User, buyer: User): List<ContractStatusChange> {
        val postedChange = ContractStatusChange(contractId, seller, Date(), ContractStatus.Posted)
        val acceptedChange = ContractStatusChange(contractId, buyer, Date(), ContractStatus.Accepted)
        return listOf(postedChange, acceptedChange)
    }
}