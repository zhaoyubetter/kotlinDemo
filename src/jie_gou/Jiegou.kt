package jie_gou

/**
 * 解构
 * Created by zhaoyu on 2017/6/21.
 */
data class User(val name: String, val age: Int) {

}

fun main(args: Array<String>) {
    val user: User = User("better", 29)

    val (name, age) = user  // 解构
    println("$name : $age")

    // 以下等价
    val name1 = user.component1()
    val age1 = user.component2()
    println("$name1 : $age1")


    // 遍历 map
    val map = mapOf("one" to 1, "two" to 2)
    for ((key, value) in map) {
        println("$key ----> $value")
    }

    //
    map.mapValues { (key, value) -> println("$key ----> $value") }
    map.mapValues { entry -> println("${entry.value}") }



}
