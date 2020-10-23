package reviews

import contracts.Contract

class ReviewService: IReviewService {
    private val repository: ReviewRepository

    constructor(reviewRepository: ReviewRepository) {
        repository = reviewRepository
    }

    override fun getReviews(contract: Contract): List<Review> {
        return repository.find()
    }

    override fun postReview(review: Review) {
        if (canBePosted(review)) {
            repository.save(review)
        }
    }

    private fun canBePosted(review: Review): Boolean {
        return validate(review)
    }

    private fun validate(review: Review): Boolean {
        return review.id > 0 && review.text.isNotEmpty() && !containsBannedWords(review.text)
    }

    private fun containsBannedWords(content: String): Boolean {
        return false
    }
}