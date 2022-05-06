package dev.efantini.yaat.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.room.Update
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import dev.efantini.yaat.data.model.BaseObject
import java.lang.reflect.ParameterizedType

@Dao
abstract class BaseDao<T : BaseObject> {

    private fun getTableName(): String {
        val clazz =
            (javaClass.superclass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<*>
        return clazz.simpleName
    }

    open suspend fun getListWhereOrder(where: String, order: String): List<T>? {
        return getByRawQuery(
            SimpleSQLiteQuery(
                "SELECT * FROM " + getTableName() +
                    if (where.isBlank()) {
                        ""
                    } else {
                        " WHERE $where"
                    } +
                    " ORDER BY " +
                    order.ifBlank {
                        BaseObject::id.name
                    }
            )
        )
    }

    open suspend fun getElementById(elementId: Long): T? {
        val query = SimpleSQLiteQuery(
            "SELECT * FROM " + getTableName() + " WHERE " +
                BaseObject::id.name + " = " + elementId
        )
        return getByRawQuery(query).firstOrNull()
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(element: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(elements: List<T>)

    @Update
    abstract suspend fun update(elements: T)

    @Delete
    abstract suspend fun delete(element: T)

    open suspend fun deleteAll() {
        val query = SimpleSQLiteQuery("DELETE FROM " + getTableName())
        getByRawQuery(query)
    }

    @RawQuery
    abstract suspend fun getByRawQuery(query: SupportSQLiteQuery): List<T>
}
