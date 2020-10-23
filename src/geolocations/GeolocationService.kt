package geolocations

import interfaces.IGeolocationService
import users.User

class GeolocationService: IGeolocationService {
    override fun getGeolocationOfUser(user: User): Geolocation {
        TODO("Not yet implemented")
    }

    override fun isWithinRange(source: Geolocation, target: Geolocation, range: Long): Boolean {
        val latitudeRange = (source.latitude - range).rangeTo(source.latitude + range)
        val longitudeRange = (source.longitude - range).rangeTo(source.longitude + range)
        return target.latitude in latitudeRange && target.longitude in longitudeRange
    }
}