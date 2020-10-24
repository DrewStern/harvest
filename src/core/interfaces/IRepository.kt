package core.interfaces

interface IRepository<T: Any> {
    fun find(): List<T>

    fun find(id: Int): T

    fun save(item: T): Boolean

    //    abstract fun archive()
}