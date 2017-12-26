package com.test



/**
 * Created by zhaoyu1 on 2017/12/14.
 */

// 编译器常量
const val SOLID = "1234"

// 惰性初始化
class Child(lateinit var num:String) {  // 不能用于构造函数
    lateinit var name:String    // 惰性初始化
    lateinit var age:Int        // 不能用 kotlin的原生类型
    lateinit var num2:String?   // 不能非空类型

    object Tmp {
        const val A = "abc"
    }
}

fun main(args: Array<String>) {
    val list = mutableListOf("a", "b", "c")
    val c = Child()
    println(c.name)
}
