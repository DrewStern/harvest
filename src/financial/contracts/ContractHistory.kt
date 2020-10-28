package financial.contracts

data class ContractHistory(
    val contractId: Int,
    val updates: List<ContractUpdate>
)