package by_

/**
 * Created by zhaoyu on 2017/6/19.
 */

class MyUser(val map: Map<String, Any?>) {
    val name: String by map  // 使用映射实例自身作为委托来实现委托属性。
    val age: Int by map
}

fun main(args: Array<String>) {
    val user = MyUser(mapOf(
            "name" to "better",
            "age" to 25
    ))

    println(user.name)
    println(user.age)
}

