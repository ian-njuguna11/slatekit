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

interface Cache {

    /**
     * settings for the cache
     */
    val settings: CacheSettings

    /**
     * number of items in the cache
     * @return
     */
    fun size(): Int

    /**
     * gets the keys in the cache
     */
    fun keys(): List<String>

    /**
     * whether the cache contains the key
     * @param key
     * @return
     */
    fun contains(key: String): Boolean

    /**
     * Gets stats on all entries
     */
    fun stats():List<CacheStats>

    /**
     * puts an item in the cache and loads it immediately
     * @param key
     * @param desc
     * @param seconds
     * @param fetcher
     * @tparam T
     */
    fun <T> put(key: String, desc: String, seconds: Int, fetcher: suspend () -> T?)

    /**
     * Sets an explict value for the entry
     */
    fun <T> set(key: String, value:T?)

    /**
     * removes a item from the cache
     * @param key
     * @return
     */
    fun remove(key: String): Boolean

    /**
     * removes all items from the cache
     */
    fun clear(): Boolean

    /**
     * manual / explicit refresh of a cache item
     * @param key
     */
    fun refresh(key: String)

    /**
     * invalidates a single cache item by its key
     * @param key
     */
    fun invalidate(key: String)

    /**
     * invalidates all the cache items
     */
    fun invalidateAll()
}



