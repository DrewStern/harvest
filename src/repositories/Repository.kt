package repositories

abstract class Repository<T: Any> {

    abstract fun find(): List<T>

    abstract fun save(item: T): Boolean
}