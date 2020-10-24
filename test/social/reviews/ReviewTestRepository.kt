package social.reviews

import core.interfaces.IRepository

class ReviewTestRepository: IRepository<Review> {
    override fun find(): List<Review> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Review {
        TODO("Not yet implemented")
    }

    override fun save(item: Review): Boolean {
        TODO("Not yet implemented")
    }
}