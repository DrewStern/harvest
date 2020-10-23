package bases

abstract class Repository<T: Any> {

    abstract fun find(): List<T>

    abstract fun find(id: Int): T

    abstract fun save(item: T): Boolean

//    abstract fun archive()
}