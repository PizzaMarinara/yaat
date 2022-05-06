package dev.efantini.yaat.data.repositories

import dev.efantini.yaat.data.dao.BaseDao
import dev.efantini.yaat.data.model.BaseObject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseRepository<T : BaseObject>(
    private val dao: BaseDao<T>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getElementById(id: Long): T? {
        return withContext(defaultDispatcher) {
            return@withContext dao.getElementById(id)
        }
    }
    suspend fun getListWhereOrder(where: String, order: String): List<T> {
        return withContext(defaultDispatcher) {
            return@withContext dao.getListWhereOrder(where, order) ?: listOf()
        }
    }
    suspend fun putElements(element: T) {
        withContext(defaultDispatcher) {
            dao.insert(element)
        }
    }
    suspend fun putElements(elements: List<T>) {
        withContext(defaultDispatcher) {
            dao.insert(elements)
        }
    }
    suspend fun deleteElement(element: T) {
        withContext(defaultDispatcher) {
            dao.delete(element)
        }
    }
    suspend fun deleteAll() {
        withContext(defaultDispatcher) {
            dao.deleteAll()
        }
    }
}
