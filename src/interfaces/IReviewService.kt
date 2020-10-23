package interfaces

import contracts.Contract
import reviews.Review

interface IReviewService {
    fun getReviews(contract: Contract): List<Review>
    fun postReview(review: Review)
}