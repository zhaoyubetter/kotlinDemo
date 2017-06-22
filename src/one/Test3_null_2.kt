package one

/**
 * test null 2
 * Created by zhaoyu on 2017/6/22.
 */

fun main(args: Array<String>) {
    val a: String? = "abc"
    val b = a as? Int
    println(b)      // null ，转换失败时，为null

    println("====")
    testException()
}

class User(val name: String?) {

}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun testException() {
    val user: User = User(null)
    user.name ?: fail("Name required!")
}