package com.better.extends_

/**
 * 伴生对象
 */
class Myclass {
    companion object {
    }
}

//伴生对象扩展函数
fun Myclass.Companion.func() {
    println("这是伴生对象扩展函数")
}

//伴生对象扩展属性
val Myclass.Companion.name: String
    get() = "Lynnma"

fun main(args: Array<String>) {
    Myclass.func()
    println(Myclass.name)
}