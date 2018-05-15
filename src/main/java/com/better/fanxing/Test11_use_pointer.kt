package com.better.fanxing

/**
 * Created by zhaoyu on 2018/2/4.
 */

// (不变型) 从一个集合copy到另一个集合
fun <T> copyData(source: MutableList<T>, destination: MutableList<T>) {
    for (item in source) {
        destination += item
    }
}

// 特定类型
fun <T : R, R> copyData2(source: MutableList<T>, destination: MutableList<R>) {
    for (item in source) {
        destination += item
    }
}

// kotlin 使用点变型：给类型参数加上 变型修饰符
fun <T> copyData3(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) {
        destination += item
    }
}


class MyCopy<T : R, R> {
    fun copyData4(source: MutableList<T>, destination: MutableList<R>) {
        for (item in source) {
            destination += item
        }
    }
}


fun main(args: Array<String>) {
    val source = mutableListOf("abc", "efg")
    val destination = mutableListOf<String>()
    copyData(source, destination)

    // copyData2
    val source2 = mutableListOf("abc", "efg")
    var destination2 = mutableListOf<Any>()
    copyData2(source2, destination2)

    // copyData3
    val source3 = mutableListOf("better", "cc")
    var destination3 = mutableListOf<Any>()
    copyData3(source3, destination3)
    println(destination3)


    MyCopy<String, Any>().copyData4(source3, destination3)

    val list: MutableList<out Number> = mutableListOf(1, 2, 3)
//    list.add(22)    // 禁止调用 in 位置上的方法

}