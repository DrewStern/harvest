package social.reviews

import experiments.IEntity

class ReviewEntity: IEntity<Review> {
    override val id: Int
    override val item: Review

    constructor(id: Int, item: Review) {
        this.id = id
        this.item = item
    }
}