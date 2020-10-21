package properties

import locations.Geolocation
import users.User

data class Property(
    val id: Int,
    val owner: User,
    // TODO: these need to be ordered in a consistent way (e.g., starting from North and going clockwise)
    val bounds: List<Geolocation>,
    // physical size, as measured in km^2
    val magnitude: Long
)