package com.test.array

fun main(args: Array<String>) {
    val array = Array(5) { 0 }

    // IntArray类
    val array2 = intArrayOf(1, 2, 3, 4, 5)
    // 使用库函数
    val array3 = arrayOf(1, 2, 3, 4, 5)

    array3[2] = 19
}