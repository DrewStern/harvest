package contracts

import harvests.Harvest
import harvests.HarvestType
import locations.Geolocation
import properties.Property
import tools.DateTimeRange
import users.Privilege
import users.User
import java.util.*

class ContractService: IContractService {
    var openContracts = mutableListOf<Contract>()


    override fun getContracts(): List<Contract> {
        val fakeId = 1
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin)
        val fakeBuyer = User(2, "Jon", "Bargiel", TimeZone.getDefault(), emptyList(), Privilege.Guest)
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeLand = Property(1, fakeSeller, fakeBounds, 100)
        val fakeHarvest = Harvest(HarvestType.Deer, 2);
        val fakePosted = Date()
        val fakeClosed = Date()
        val fakeExpiration = Date()
        val fakeTimeframe = DateTimeRange(fakePosted, fakeExpiration)
        val fakeContract = Contract(
            fakeId, fakeSeller, fakeBuyer, fakePrice, fakeLand, fakeHarvest, fakePosted, fakeClosed, fakeExpiration, fakeTimeframe)
        return mutableListOf(fakeContract)
    }

    override fun postContract(contract: Contract) {
        openContracts.add(contract)
    }
}