package contracts.tests

import contracts.*

class ContractServiceTestDataFactory {

    fun getBasicTestData() {
        val fakeId = 1
        val fakeSeller = User(1, "Drew", "Stern")
        val fakeBuyer = User(2, "Jon", "Bargiel")
        val fakeBounds = emptyList<Geolocation>()
        val fakeLand = Land(1, fakeSeller, fakeBounds, 100)
        val fakePosted = Date()
        val fakeClosed = Date()
        val fakeExpiration = Date()
        val fakeTimeframe = DateTimeInterval(fakePosted, fakeExpiration)

        return Contract(
            fakeId, fakeSeller, fakeBuyer, fakeLand, fakePosted, fakeClosed, fakeExpiration, fakeTimeframe)
    }
}