package slatekit.common.functions


interface Function {
    val info: FunctionInfo
    val name:String get() { return info.name }
}