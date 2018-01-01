package com.better.delegate


/**
 * 属性委托 - by lazy
 * https://www.jianshu.com/p/306bdc2bac3f
 * Created by zhaoyu on 2018/1/1.
 */

class LazyClass {
    // 复习 延迟初始化
    lateinit var x: String

    // 延迟属性的委托
    val lazyValue: Int by lazy  {
        println("属性委托延迟初始化 ")
        100
    }

    fun printX() {
        x = "abcd"
        println(x)
    }
}

fun main(args: Array<String>) {
    val l = LazyClass()
    l.printX()      // 延迟初始化

    l.lazyValue     // 属性委托lazy
    l.lazyValue
}