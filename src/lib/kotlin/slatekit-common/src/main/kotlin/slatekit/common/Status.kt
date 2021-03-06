package slatekit.common

/**
 * Represents the different "states" of a life-cycle
 */
sealed class Status(val name:String, val value:Int) {
    object InActive : Status("InActive", 0)
    object Starting : Status("Starting", 1)
    object Idle     : Status("Idle"    , 2)
    object Running  : Status("Running" , 3)
    object Paused   : Status("Paused"  , 4)
    object Stopped  : Status("Stopped" , 5)
    object Complete : Status("Complete", 6)
    object Failed   : Status("Failed"  , 7)
}


interface StatusCheck {
    /**
     * gets the current status of the application
     *
     * @return
     */
    fun status(): Status

    /**
     * whether this is executing
     *
     * @return
     */
    fun isRunning(): Boolean = isState(Status.Running)

    /**
     * whether this is waiting
     *
     * @return
     */
    fun isIdle(): Boolean = isState(Status.Idle)

    /**
     * whether this is paused
     *
     * @return
     */
    fun isPaused(): Boolean = isState(Status.Paused)

    /**
     * whether this is stopped
     *
     * @return
     */
    fun isStopped(): Boolean = isState(Status.Stopped)

    /**
     * whether this is complete
     *
     * @return
     */
    fun isComplete(): Boolean = isState(Status.Complete)

    /**
     * whether this has failed
     *
     * @return
     */
    fun isFailed(): Boolean = isState(Status.Failed)

    /**
     * whether this is not running ( stopped or paused )
     *
     * @return
     */
    fun isStoppedOrPaused(): Boolean = isState(Status.Stopped) || isState(Status.Paused)

    /**
     * whether the current state is at the one supplied.
     *
     * @param runState
     * @return
     */
    fun isState(status: Status): Boolean = status() == status
}
