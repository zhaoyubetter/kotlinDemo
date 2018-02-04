package com.better.fanxing

/**
 * Created by zhaoyu on 2018/2/3.
 */

inline fun <reified T> isA(value: Any) = value is T
fun main(args: Array<String>) {
    isA<Int>(1)  //  isA(1)

}
