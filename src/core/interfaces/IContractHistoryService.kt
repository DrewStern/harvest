package core.interfaces

import financial.contracts.Contract
import financial.contracts.ContractHistory

interface IContractHistoryService {
    fun getHistory(contract: Contract): ContractHistory
}