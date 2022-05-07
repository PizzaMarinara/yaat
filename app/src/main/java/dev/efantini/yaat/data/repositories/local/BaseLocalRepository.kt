package dev.efantini.yaat.data.repositories.local

import dev.efantini.yaat.data.dao.BaseDao
import dev.efantini.yaat.data.model.BaseObject
import dev.efantini.yaat.data.repositories.BaseRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseLocalRepository<T : BaseObject>(
    private val dao: BaseDao<T>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseRepository<T> {
    override suspend fun getElementById(id: Long): T? {
        return withContext(defaultDispatcher) {
            return@withContext dao.getElementById(id)
        }
    }
    override suspend fun putElements(elements: List<T>) {
        withContext(defaultDispatcher) {
            dao.insert(elements)
        }
    }

    override suspend fun updateElement(element: T) {
        withContext(defaultDispatcher) {
            dao.insert(element)
        }
    }
    override suspend fun deleteElement(element: T) {
        withContext(defaultDispatcher) {
            dao.delete(element)
        }
    }
    override suspend fun deleteAll() {
        withContext(defaultDispatcher) {
            dao.deleteAll()
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
}
