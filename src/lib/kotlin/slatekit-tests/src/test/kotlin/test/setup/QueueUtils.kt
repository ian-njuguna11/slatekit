package test.setup

import slatekit.apis.support.QueueSupport
import slatekit.core.queues.Queue

interface QueueSupportImpl : QueueSupport {


    fun queues(): List<Queue<String>>

    /**
     * Creates a request from the parameters and api info and serializes that as json
     * and submits it to a random queue.
     * This is designed to work with slatekit.jobs
     *  @param id       = "ABC123",
     *  @param name     = "users.sendWelcomeEmail",
     *  @param data     = "JSON data...",
     *  @param xid      = "abc123"
     */
    override fun enueue(id: String, name: String, data: String, xid: String) {
        val queues = this.queues()
        val rand = java.util.Random()
        val pos = rand.nextInt(queues.size)
        val queue = queues[pos]
        queue.send(data, mapOf(
                "id" to id,
                "name" to name,
                "xid" to xid
        ))
    }
}