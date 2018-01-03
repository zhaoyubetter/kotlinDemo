package com.better.clazz.data.anonymity

/**
 * Created by zhaoyu1 on 2017/12/27.
 */
interface CallBack {
    fun method()
}

class Net {
    fun invoke(callback : CallBack) {
        callback.method()
    }
}

fun main(args: Array<String>) {
    val net = Net()
    net.invoke(object:CallBack {
        override fun method() {
        }
    })
}