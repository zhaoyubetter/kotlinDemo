package com.better.fanxing


/**
 * Created by zhaoyu on 2018/2/3.
 */

val <T> kotlin.collections.List<T>.penultimate: T
    get() = this[size - 1]

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4).penultimate)
}
