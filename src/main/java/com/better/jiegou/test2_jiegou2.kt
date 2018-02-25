package com.better.jiegou

fun main(args: Array<String>) {
    val map = mapOf("1" to "one", "2" to "two")
    map.forEach { t, u ->

    }

    map.forEach { (k , v) ->

    }

    // 匿名函数不能解构
    map.forEach(fun(entry) {

    })
}