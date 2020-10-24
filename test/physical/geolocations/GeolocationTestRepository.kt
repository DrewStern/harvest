package physical.geolocations

import core.interfaces.IRepository

class GeolocationTestRepository: IRepository<Geolocation> {
    lateinit var fakeGeolocationData: List<Geolocation>

    override fun find(): List<Geolocation> {
        return listOf(getFakeGeolocation())
    }

    override fun find(id: Int): Geolocation {
        return getFakeGeolocation()
    }

    override fun save(item: Geolocation): Boolean {
        TODO("Not yet implemented")
    }

    private fun getFakeGeolocation(): Geolocation {
        return Geolocation(1, 200.2, 400.4)
    }
}