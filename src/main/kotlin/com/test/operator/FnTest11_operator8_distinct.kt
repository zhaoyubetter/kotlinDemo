package com.test.operator

fun main(args: Array<String>) {
    val list = listOf(1, 1, 2, 2, -1, -2, 3, 9, -9, 5)
    println(list.distinct())                    // [1, 2, -1, -2, 3, 9, -9, 5]
    println(list.distinctBy { Math.abs(it) })  // [1, 2, 3, 9, 5]
}