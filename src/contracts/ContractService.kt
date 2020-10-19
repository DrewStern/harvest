package contracts

import locations.Geolocation
import locations.Land
import tools.DateTimeRange
import users.User
import java.util.*

class ContractService: IContractService {
    var openContracts = mutableListOf<Contract>()


    override fun getContracts(): List<Contract> {
        val fakeId = 1
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList())
        val fakeBuyer = User(2, "Jon", "Bargiel", TimeZone.getDefault(), emptyList())
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeLand = Land(1, fakeSeller, fakeBounds, 100)
        val fakePosted = Date()
        val fakeClosed = Date()
        val fakeExpiration = Date()
        val fakeTimeframe = DateTimeRange(fakePosted, fakeExpiration)
        val fakeContract = Contract(
            fakeId, fakeSeller, fakeBuyer, fakePrice, fakeLand, fakePosted, fakeClosed, fakeExpiration, fakeTimeframe)
        return mutableListOf(fakeContract)
    }

    override fun postContract(contract: Contract) {
        openContracts.add(contract)
    }
}