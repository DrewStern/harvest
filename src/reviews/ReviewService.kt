package reviews

import contracts.Contract

class ReviewService: IReviewService {
    val reviews = mutableListOf<Review>()

    override fun getReviews(contract: Contract): List<Review> {
        return reviews
    }

    override fun postReview(review: Review) {
        reviews.add(review)
    }
}