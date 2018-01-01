package com.better.delegate

/**
 * Created by zhaoyu on 2018/1/1.
 */
interface Base {
    fun method()
}

class BaseImpl(val x:Int) : Base {
    override fun method() {
        println("method call print ${x}")
    }
}

// 继承 Base 通过委托b实现
class BaseImpl2(b: Base) : Base by b

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    BaseImpl2(b).method()
}