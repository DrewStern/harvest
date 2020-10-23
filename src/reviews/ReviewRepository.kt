package reviews

import bases.Repository

class ReviewRepository: Repository<Review>() {
    override fun find(): List<Review> {
        TODO("Not yet implemented")
    }

    override fun find(id: Int): Review {
        TODO("Not yet implemented")
    }

    override fun save(review: Review): Boolean {
        TODO("Not yet implemented")
    }
}