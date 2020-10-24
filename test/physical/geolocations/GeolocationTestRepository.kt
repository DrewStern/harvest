package physical.geolocations

import core.interfaces.IRepository

class GeolocationTestRepository: IRepository<Geolocation> {
    override fun find(): List<Geolocation> {
        return emptyList()
    }

    override fun find(id: Int): Geolocation {
        TODO("Not yet implemented")
    }

    override fun save(item: Geolocation): Boolean {
        TODO("Not yet implemented")
    }
}