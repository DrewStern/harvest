package contracts.tests

import contracts.*

class ContractServiceTestDataFactory {

    fun getBasicTestData(): Contract {
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
        return fakeContract
    }
}