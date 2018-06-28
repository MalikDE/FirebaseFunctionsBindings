fun toInt(arg: dynamic): Int {
    if (arg is String) {
        return arg.toString().toInt()
    } else {
        throw NumberFormatException()
    }
}

fun debuglog(message: String) {
    console.log(message)
}