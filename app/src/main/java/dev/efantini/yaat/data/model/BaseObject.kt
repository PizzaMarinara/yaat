package dev.efantini.yaat.data.model

interface BaseObject {
    val id: Long?

    fun populateObject(fields: List<String>): BaseObject? {
        return null
    }
}
