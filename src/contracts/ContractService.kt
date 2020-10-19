package contracts

import locations.Geolocation
import locations.Land
import tools.DateTimeInterval
import users.User
import java.util.*

class ContractService: IContractService {
    val isTrue : Boolean get() = true


    val fakeId = 1
    val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList())
    val fakeBuyer = User(2, "Jon", "Bargiel", TimeZone.getDefault(), emptyList())
    val fakeBounds = emptyList<Geolocation>()
    val fakeLand = Land(1, fakeSeller, fakeBounds, 100)
    val fakePosted = Date()
    val fakeClosed = Date()
    val fakeExpiration = Date()
    val fakeTimeframe = DateTimeInterval(fakePosted, fakeExpiration)

    val fakeContract = Contract(
        fakeId, fakeSeller, fakeBuyer, fakeLand, fakePosted, fakeClosed, fakeExpiration, fakeTimeframe)

    override fun getContracts(): List<Contract> {
        println(isTrue)
        return mutableListOf(fakeContract)
    }
}