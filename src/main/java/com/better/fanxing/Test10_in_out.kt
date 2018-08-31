package com.better.fanxing

import java.util.function.Function
import java.util.stream.Stream

/**
 * Created by zhaoyu on 2018/2/4.
 */

interface MyTranform<T> {
    fun tranform(t: T): T   // 参数 t，in 位置，返回值 out位置
}



val anyComparator = Comparator<Any> {
    e1, e2 ->
    e1.hashCode() - e2.hashCode()
}

fun main(args: Array<String>) {
    val strings = listOf("B", "A", "War")

    println(strings.sortedWith(anyComparator))
}