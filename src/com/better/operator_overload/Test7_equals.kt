package com.better.operator_overload

fun main(args: Array<String>) {
    val p = Pointer(1, 2)
    val p2 = Pointer(1, 2)
    println(p == p2)
}