package com.test._packag

/**
 * 包测试
 **/

fun test1() {
    println("顶层函数调用")
}

fun sum(vararg v: Int): Int {
    var sum = 0
    for (a in v) {
        sum += a
    }
    return sum
}
class FirstClass {
}