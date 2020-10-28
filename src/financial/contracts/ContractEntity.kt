package financial.contracts

import core.interfaces.IEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class ContractEntity: IEntity<Contract> {
    override val id: Int
    override val item: Contract

    val isOpen: Boolean
        get() = isInStatus(ContractStatus.Posted)

    val isClosed: Boolean
        get() = isInStatus(ContractStatus.Closed)

    val hasExpired: Boolean
        get() {
            val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
            return now >= item.expiration
        }

    constructor(id: Int, item: Contract) {
        this.id = id
        this.item = item
    }

    fun isInStatus(status: ContractStatus): Boolean {
        return item.history.changes.last().status == status
    }
}