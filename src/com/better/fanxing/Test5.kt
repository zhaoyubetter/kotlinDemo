package com.better.fanxing

/**
 * Created by zhaoyu on 2018/2/3.
 */
fun main(args: Array<String>) {
    // 判断
    val list = listOf(1,2,3)
    if(list is kotlin.collections.List<*>) {
        println("ok")
    } else {
        println("--")
    }

}