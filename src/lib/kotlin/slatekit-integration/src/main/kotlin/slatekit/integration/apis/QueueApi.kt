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

package slatekit.integration.apis

import slatekit.apis.Api
import slatekit.apis.Action
import slatekit.apis.AuthModes
import slatekit.apis.Verbs
import slatekit.apis.support.FileSupport
import slatekit.common.Context
import slatekit.common.Sources
import slatekit.common.types.Doc
import slatekit.common.encrypt.Encryptor
import slatekit.common.log.Logger
import slatekit.core.queues.AsyncQueue
import slatekit.results.Try

@Api(area = "cloud", name = "queues", desc = "api info about the application and host",
        auth = AuthModes.KEYED, roles = ["admin"], verb = Verbs.AUTO, sources = [Sources.ALL])
class QueueApi(val queue: AsyncQueue<String>, override val context: Context) : FileSupport {

    override val encryptor: Encryptor? = context.enc
    override val logger: Logger? = context.logs.getLogger()


    @Action(desc = "close the queue")
    suspend fun close() {
        return queue.close()
    }

    @Action(desc = "get the total items in the queue")
    suspend fun count(): Int {
        return queue.count()
    }

    @Action(desc = "get the next item in the queue")
    suspend fun next(complete: Boolean): Any? {
        val item = queue.next()
        if (complete) {
            queue.done(item)
        }
        return item
    }

    @Action(desc = "get the next set of items in the queue")
    suspend fun nextBatch(size: Int = 10, complete: Boolean): List<Any> {
        val items = queue.next(size)
        items?.let { all ->
            for (item in items) {
                if (complete) {
                    queue.done(item)
                }
            }
        }
        return items ?: listOf()
    }

    @Action(desc = "gets next item and saves it to file")
    suspend fun nextToFile(complete: Boolean, fileNameLocal: String): Any? {
        val item = queue.next()
        if (complete) {
            queue.done(item)
        }
        return writeToFile(item, fileNameLocal, 0) { m -> item?.getValue() ?: "" }
    }

    @Action(desc = "gets next set of items and saves them to files")
    suspend fun nextBatchToFiles(size: Int = 10, complete: Boolean, fileNameLocal: String): List<String?> {
        val items = queue.next(size)
        val result = items?.let { all ->
            val res= all.mapIndexed { index, entry ->
                val content = entry.getValue() ?: ""
                writeToFile(all[index], fileNameLocal, index) { content }
                content
            }
            res
        } ?: listOf<String?>("No items available")
        return result
    }

    @Action(desc = "sends a message to the queue")
    suspend fun send(msg: String, tagName: String = "", tagValue: String = ""): Try<String> {
        return queue.send(msg, tagName, tagValue)
    }

    @Action(desc = "sends a message to queue using content from file")
    suspend fun sendFromFile(uri: String, tagName: String = "", tagValue: String = ""): Try<String> {
        return queue.sendFromFile(uri, tagName, tagValue)
    }

    @Action(desc = "sends a message to queue using content from file")
    suspend fun sendFromDoc(doc: Doc, tagName: String = "", tagValue: String = ""): Try<String> {
        return queue.send(doc.content, tagName, tagValue)
    }
}
