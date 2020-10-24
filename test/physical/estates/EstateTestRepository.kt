package physical.estates

import core.interfaces.IRepository

class EstateTestRepository: IRepository<Estate> {

    override fun find(): List<Estate> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Estate {
        TODO("Not yet implemented")
    }

    override fun save(item: Estate): Boolean {
        TODO("Not yet implemented")
    }
}