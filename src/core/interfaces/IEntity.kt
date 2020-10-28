package core.interfaces

interface IEntity<T: Any> {
    val id: Int
    val entity: T
}