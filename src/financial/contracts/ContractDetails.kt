package financial.contracts

import physical.estates.Estate
import physical.harvests.Harvest

data class ContractDetails(
    val contractId: Int,
    val price: Long, // note that kotlin already supports LongRange, but not DateTimeRange unfortunately
    val estate: Estate,
    val harvest: Harvest
)