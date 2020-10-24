package financial.contracts

import physical.estates.Estate
import physical.harvests.Harvest
import physical.harvests.HarvestType
import physical.geolocations.Geolocation
import core.interfaces.IRepository
import social.calendars.DateRange
import social.users.Privilege
import social.users.User
import java.util.*

class ContractRepository: IRepository<Contract> {
    override fun find(): List<Contract> {
        return mutableListOf(getFakeContract())
    }

    override fun find(id: Int): Contract {
        return find().filter { contract -> contract.id.equals(id) }.first()
    }

    fun save(contract: Contract, toStage: ContractStage): Boolean {
        return true
    }

    override fun save(contract: Contract): Boolean {
        return true
    }

    // TODO: the existence of this here leads to a lot of extraneous import statements
    private fun getFakeContract(): Contract {
        val fakeId = 1
        val fakeSeller = User(1, "Drew", "Stern", TimeZone.getDefault(), emptyList(), Privilege.Admin, "fake@fake", "123-456-7890")
        val fakeBuyer = User(2, "Jon", "Bargiel", TimeZone.getDefault(), emptyList(), Privilege.Guest, "fake@fake", "123-456-7890")
        val fakeBounds = emptyList<Geolocation>()
        val fakePrice = Long.MAX_VALUE
        val fakeEstate = Estate(1, fakeSeller, fakeBounds, 100)
        val fakeHarvest =
            Harvest(1, HarvestType.Deer, 2)
        val fakeStage = ContractStage.Posted
        val fakePosted = Date()
        val fakeClosed = Date()
        val fakeAccepted = Date()
        val fakeExpiration = Date()
        val fakeTimeframe = DateRange(fakePosted, fakeExpiration)
        val fakeContract = Contract(
            fakeId, fakeSeller, fakeBuyer, fakePrice, fakeEstate, fakeHarvest, fakeStage,
            fakePosted, fakeClosed, fakeAccepted, fakeExpiration, fakeTimeframe
        )
        return fakeContract
    }
}