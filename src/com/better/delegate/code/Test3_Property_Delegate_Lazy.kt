package com.better.delegate.code


/**
 * 延迟属性委托
 */
class LazyClass {

    // 延迟属性委托
    val lazyValue: String by lazy {
        println("get value")
        "Hello"
    }

    // 延迟初始化
    lateinit var lateValue: String

    fun printLateValue(): String {
        lateValue = "abc"
        return lateValue
    }
}


fun main(args: Array<String>) {
    val l = LazyClass()
    println(l.lazyValue)
    println(l.lazyValue)

    // 延迟属性
    println(l.printLateValue())
    println(l.printLateValue())
}
