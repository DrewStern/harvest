package financial.contracts

import core.interfaces.IEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class ContractEntity: IEntity<Contract> {
    override val id: Int
    override val entity: Contract

    val isOpen: Boolean
        get() = isInStatus(ContractStatus.Open)

    val isClosed: Boolean
        get() = isInStatus(ContractStatus.Closed)

    val hasExpired: Boolean
        get() {
            val now = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))
            return now >= entity.expiration
        }

    constructor(id: Int, item: Contract) {
        this.id = id
        this.entity = item
    }

    fun isInStatus(status: ContractStatus): Boolean {
        return entity.history.updates.last().status == status
    }
}