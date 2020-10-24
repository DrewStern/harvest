package core.interfaces

import financial.contracts.Contract
import social.reviews.Review

interface IReviewService {
    fun getReviews(contract: Contract): List<Review>
    fun postReview(review: Review)
}