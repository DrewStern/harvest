package financial.contracts

import core.interfaces.IRepository
import physical.estates.Estate
import physical.geolocations.Geolocation
import physical.harvests.Harvest
import physical.harvests.HarvestType
import social.calendars.DateRange
import social.users.Privilege
import social.users.User
import java.util.*

class ContractTestRepository: IRepository<Contract> {
    override fun find(): List<Contract> {
        return listOf(getBasicTestData())
    }

    override fun find(id: Int): Contract {
        return getBasicTestData()
    }

    override fun save(item: Contract): Boolean {
        TODO("Not yet implemented")
    }

    private fun getBasicTestData(): Contract {
        val fakeId = 1
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake.fake", "123-456-7890")
        val fakeBuyer = User(2, "Jon", "Bargiel", TimeZone.getDefault(), emptyList(), Privilege.Guest, "fake@fake.fake", "123-456-7890")
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeEstate = Estate(1, fakeSeller, fakeBounds, 100)
        val fakeHarvest = Harvest(1, HarvestType.Deer, 2);
        val fakeStage = ContractStage.Posted
        val fakePosted = Date()
        val fakeClosed = Date()
        val fakeAccepted = Date()
        val fakeExpiration = Date()
        val fakeTimeframe = DateRange(fakePosted, fakeExpiration)
        val fakeContract = Contract(
            fakeId, fakeSeller, fakeBuyer, fakePrice, fakeEstate, fakeHarvest, fakeStage,
            fakePosted, fakeClosed, fakeAccepted, fakeExpiration, fakeTimeframe)
        return fakeContract
    }
}