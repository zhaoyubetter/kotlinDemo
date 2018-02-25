package com.better.`object`

/**
 * Created by zhaoyu on 2017/12/31.
 */
class Test1() {

    interface Listener

    fun add():Int {
        // a 为匿名对象类型
        val a =  object: Listener {
            val x = 10
            val y = 20
        }

        return a.x + a.y
    }
}