package com.better.fanxing

import java.lang.IllegalArgumentException

/**
 * Created by zhaoyu on 2018/2/3.
 */

fun printTest(c: Collection<*>) {
    val intList = c as? kotlin.collections.List<Int> ?:
            throw IllegalArgumentException("转换失败")
    println(intList)
}

fun main(args: Array<String>) {
    printTest(listOf(1, 2, 3))
}