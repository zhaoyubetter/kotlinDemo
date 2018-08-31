package com.better.fanxing


/**
 * Created by zhaoyu on 2018/2/3.
 */

val <T> kotlin.collections.List<T>.penultimate: T
    get() = this[size - 1]


fun <T : Number> List<T>.sum() {

}

fun <T> List<T>.sum2() where T : Number, T : Appendable {

}

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4).penultimate)

    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(0..2))    // 推导出类型

}
