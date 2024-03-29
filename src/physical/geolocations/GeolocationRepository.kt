package physical.geolocations

import core.interfaces.IRepository

class GeolocationRepository: IRepository<Geolocation> {
    override fun find(): List<Geolocation> {
        return getFakeGeolocations()
    }

    override fun find(id: Int): Geolocation {
        return find().first { geolocation -> geolocation.id.equals(id) }
    }

    override fun save(item: Geolocation): Boolean {
        TODO("Not yet implemented")
    }

    private fun getFakeGeolocations(): List<Geolocation> {
        return mutableListOf(
            Geolocation(1, 3.14, 1000.1),
            Geolocation(2, 5.14, 2000.2),
            Geolocation(3, 7.14, 3000.3),
            Geolocation(4, 9.14, 4000.4)
        )
    }
}