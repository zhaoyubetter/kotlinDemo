package com.better.delegate

/**
 * Created by zhaoyu on 2018/1/1.
 */

interface Task {
    fun makeLogComponent()
}

class Better(val day: Int) : Task {
    override fun makeLogComponent() {
        println("better make a log component cost $day")
    }
}

// Yu并没有实现Task接口，而是将实现委托给了a
class Yu(a: Task) : Task by a


fun main(args: Array<String>) {
    val a = Better(2)
    Yu(a).makeLogComponent()

    // 通过匿名内部类
    Yu(object : Task {
        override fun makeLogComponent() {
            println("make task")
        }
    }).makeLogComponent()
}