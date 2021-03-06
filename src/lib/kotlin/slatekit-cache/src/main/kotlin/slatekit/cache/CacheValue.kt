/**
 * <slate_header>
 * url: www.slatekit.com
 * git: www.github.com/code-helix/slatekit
 * org: www.codehelix.co
 * author: Kishore Reddy
 * copyright: 2016 CodeHelix Solutions Inc.
 * license: refer to website and/or github
 * about: A tool-kit, utility library and server-backend
 * mantra: Simplicity above all else
 * </slate_header>
 */

package slatekit.cache

import slatekit.tracking.Expiry
import slatekit.tracking.Fetches
import slatekit.tracking.Tracked

/**
 * Represents a single cache item
 * @param text : The last known text value
 * @param seconds : The time in seconds this is valid for
 * @param expiry : The time it will expire
 * @param hits : Tracks total number of hits and last read time
 * @param value : Tracks current value, total updates and last update time
 */
data class CacheValue(
    val text: String?,
    val expiry: Expiry,
    val hits: Fetches,
    val value: Tracked<Any>,
    val error: Tracked<Throwable>
) {

    fun expire():CacheValue {
        return copy(expiry = expiry.expire())
    }


    fun update(result: Any?, text:String? = null):CacheValue {
        value.set(result)
        return copy(
            text = text ?: "",
            expiry = expiry.extend()
        )
    }
}
