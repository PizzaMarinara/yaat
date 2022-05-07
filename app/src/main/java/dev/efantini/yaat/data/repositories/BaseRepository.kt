package dev.efantini.yaat.data.repositories

import dev.efantini.yaat.data.model.BaseObject

interface BaseRepository<T : BaseObject> {
    suspend fun getElementById(id: Long): T?
    suspend fun putElements(elements: List<T>)
    suspend fun updateElement(element: T)
    suspend fun deleteElement(element: T)
    suspend fun deleteAll()
}
