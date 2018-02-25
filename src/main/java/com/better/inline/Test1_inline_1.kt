package com.better.inline

/**
 * 反编译看源码，就明白 inline 的意思了
 * Created by zhaoyu1 on 2018/1/3.
 */
inline fun lock() {
    println("lock() called")
}

// noinline  不内联
inline fun method(name: String, noinline colsure: (param: String) -> String) {
    println(colsure.invoke(name))
}

fun main(args: Array<String>) {
//    lock()
    method("better", { it -> "Hello " + it })
}