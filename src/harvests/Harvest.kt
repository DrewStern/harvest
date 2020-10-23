package harvests

data class Harvest(
    val id: Int,
    val type: HarvestType,
    // can be negative?? in order to demonstrate state transitions and help reporting
    val quantity: Int
)