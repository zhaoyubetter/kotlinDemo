package com.better.fanxing

import java.util.*

/**
 * Created by zhaoyu on 2018/2/4.
 */
fun main(args: Array<String>) {
    val list: MutableList<Any?> = mutableListOf('x', 1, "efg")
    list.add(5)
    val chars = mutableListOf('a', 'b', 'c')

    val unkownElems: MutableList<*> = if (Random().nextBoolean()) list else chars
    //unkownElems.add(12)  // 不能调用
    println(unkownElems.get(0))

    val list2: List<*> = listOf("aa", "bb")

    println(list)
}

fun <T> getFirst(list: List<*>): T? {
    if (!list.isEmpty()) {
        return list.first() as T
    }
    return null
}

fun <T> getFirst2(list: List<T>): T {
    return list.first()
}