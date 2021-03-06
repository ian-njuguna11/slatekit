package slatekit.functions.common

import org.threeten.bp.Duration
import slatekit.common.DateTime
import slatekit.common.ext.durationFrom
import slatekit.results.*

/**
 * The result a single execution of the function
 * @param info : The command info
 * @param mode : Mode of execution
 * @param result : Result of execution of the command
 * @param started : Start time of the command
 * @param ended : End time of the command
 */
interface FunctionResult {
    val mode: FunctionMode
    val result: Outcome<*>
    val started: DateTime
    val ended: DateTime

    val success: Boolean get() { return result.success }
    val message: String get() { return result.msg }
    val value: Any? get() { return result.getOrNull() }

    fun duration(): Duration { return ended.durationFrom(started) }

    fun error(): Throwable? {
        val r = result
        return when (r) {
            is Success -> null
            is Failure -> {
                val err = r.error
                when (err) {
                    null -> null
                    is Exception -> err
                    else -> null
                }
            }
        }
    }
}
