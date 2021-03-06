package slatekit.entities.slatekit.entities.features

import slatekit.entities.Entity
import slatekit.entities.EntityWithTime
import slatekit.entities.core.ServiceSupport

interface Purge <TId, T> : ServiceSupport<TId, T> where TId : kotlin.Comparable<TId>, T : Entity<TId>, T : EntityWithTime {

    /**
     * Purges data older than the number of days supplied
     */
    fun purge(days: Int): Int {
        return repo().purge<T>(days)
    }
}
