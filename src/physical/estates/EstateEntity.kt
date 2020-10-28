package physical.estates

import core.interfaces.IEntity

class EstateEntity: IEntity<Estate> {
    override val id: Int
    override val entity: Estate

    constructor(id: Int, item: Estate) {
        this.id = id
        this.entity = item
    }
}