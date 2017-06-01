package one

/**
 * Created by zhaoyu on 2017/5/27.
 */
fun describe(obj: Any): String =
        when (obj) {
            1 -> "one"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun main(args:Array<String>) {
    println(describe(1))
    println(describe("Hello"))
    println(describe(10000L))

}
