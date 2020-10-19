package reviews

import contracts.Contract

interface IReviewService {
    fun getReviews(contract: Contract): List<Review>
    fun postReview(review: Review)
}