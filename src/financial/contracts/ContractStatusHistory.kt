package financial.contracts

data class ContractStatusHistory(
    val contractId: Int,
    val changes: List<ContractStatusChange>
)