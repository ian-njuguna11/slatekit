package slatekit.orm.databases.statements

import slatekit.meta.models.Model
import slatekit.entities.core.Entity
import slatekit.orm.core.OrmMapper


class Delete<TId, T> : Statement<TId, T> where TId: kotlin.Comparable<TId>, T: Entity<TId> {

    override fun sql(item: Entity<TId>, model: Model, mapper: OrmMapper<TId, T>): String {
        // TODO: Have to support entity with other name for id
        val id = (item as Entity<*>).identity()
        val table = mapper.tableName()
        return "delete from $table where id = $id"
    }
}