package financial.contracts

import core.interfaces.IContractHistoryService
import core.interfaces.IRepository

class ContractHistoryService: IContractHistoryService {
    private val repository: IRepository<ContractHistory>

    constructor(repository: IRepository<ContractHistory>) {
        this.repository = repository
    }

    override fun getHistory(contract: Contract): ContractHistory {
        return ContractHistory(1, listOf())
    }
}