package tools

import contracts.Contract

class DateTimeService {

    fun isContractWithinUserDateRange(contract: Contract, userRange: DateTimeRange): Boolean {
        return userRange.start.before(contract.fulfillment.start) && userRange.end.after(contract.fulfillment.end)
    }
}
