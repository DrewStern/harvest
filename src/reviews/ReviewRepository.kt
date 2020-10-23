package reviews

import repositories.Repository

class ReviewRepository: Repository<Review>() {
    override fun find(): List<Review> {
        TODO("Not yet implemented")
    }

    override fun save(review: Review): Boolean {
        TODO("Not yet implemented")
    }
}