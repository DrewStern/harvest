package locations

data class Geolocation(
    val latitude: Long,
    val longitude: Long,
    val tolerance: Long
)