package physical.estates

import physical.geolocations.Geolocation
import social.users.User

data class Estate(
    val id: Int,
    val owner: User,
    // TODO: these need to be ordered in a consistent way (e.g., starting from North and going clockwise)
    val bounds: List<Geolocation>,
    // physical size, as measured in km^2
    val magnitude: Long
    // TODO: may want to do something like soil type, forestry, etc
)