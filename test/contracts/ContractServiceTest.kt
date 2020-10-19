package contracts.tests

import contracts.*

class ContractServiceTest {
    @Before


    @Test
    fun givenNothing_whenContractsAreQueried_thenAllAreFound() {
        val fakeId = 1
        val fakeSeller = User(1, "Drew", "Stern")
        val fakeBuyer = User(2, "Jon", "Bargiel")
        val fakeBounds = emptyList<Geolocation>()
        val fakeLand = Land(1, fakeSeller, fakeBounds, 100)
        val fakePosted = Date()
        val fakeClosed = Date()
        val fakeExpiration = Date()
        val fakeTimeframe = DateTimeInterval(fakePosted, fakeExpiration)

        val fakeContract = Contract(
            fakeId, fakeSeller, fakeBuyer, fakeLand, fakePosted, fakeClosed, fakeExpiration, fakeTimeframe)

        val expected = fakeContract
        val actual = fakeContract
    }
}