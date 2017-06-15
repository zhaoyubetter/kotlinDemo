package copy

/**
 * Created by zhaoyu1 on 2017/6/15.
 */
data class User(var name: String = "", var age: Int = 0) {
}

fun main(args: Array<String>) {
    val user1: User = User(name = "better", age = 30)
    println(user1)

    val user2: User = user1.copy(name = "cc")
    println(user2)
}