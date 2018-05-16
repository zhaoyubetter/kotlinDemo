package cz.sample.kotlin.companion_

// 扩展函数

class Person2 {
    companion object {

    }
}

// 与原模块无耦合
fun Person2.Companion.fromJson(json: String) : Person2{
    // 模拟
    return Person2()
}

fun main(args: Array<String>) {
    // 无耦合操作
    println(Person2.fromJson("{}"))
}