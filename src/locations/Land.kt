package locations

import users.User

data class Land(
    val id: Int,
    val owner: User,
    // TODO: these need to be ordered in a consistent way (e.g., starting from North and going clockwise)
    val bounds: List<Geolocation>,
    // physical size, as measured in km^2
    val magnitude: Int
)