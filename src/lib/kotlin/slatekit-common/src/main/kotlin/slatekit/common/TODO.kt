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


object TODO {

    /**
     * Indicates that code is not implemented
     * @param tag
     * @param msg
     * @param callback
     */
    fun REMOVE(tag: String = "", msg: String = "", callback: (() -> Unit)? = null) {
        exec("TODO(remove): " + msg, tag, callback)
    }


    /**
     * Indicates that code is not implemented
     * @param tag
     * @param msg
     * @param callback
     */
    fun NOT_IMPLEMENTED(tag: String = "", msg: String = "", callback: (() -> Unit)? = null) {
        exec("TODO(not_implement): " + msg, tag, callback)
    }


    /**
     * Indicates that an implementation is required
     * @param tag
     * @param msg
     * @param callback
     */
    fun IMPLEMENT(tag: String = "", msg: String = "", callback: (() -> Unit)? = null) {
        exec("TODO(implement): " + msg, tag, callback)
    }


    /**
     * Indicates that a refactoring is required
     * @param tag
     * @param msg
     * @param callback
     */
    fun REFACTOR(tag: String = "", msg: String = "", callback: (() -> Unit)? = null) {
        exec("TODO(refactor): " + msg, tag, callback)
    }


    /**
     * Indicates a bug
     * @param tag
     * @param msg
     * @param bugId
     * @param callback
     */
    fun BUG(tag: String = "", msg: String = "", bugId: String = "", callback: (() -> Unit)? = null) {
        exec("TODO(bug) $bugId: $msg", tag, callback)
    }


    private fun exec(msg: String, tag: String, callback: (() -> Unit)? = null) {
    }
}