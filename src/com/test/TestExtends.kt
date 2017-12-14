package com.test
import com.better.extends_.betterSwap
import com.better.extends_.lastIndex

/**
 * Created by zhaoyu1 on 2017/12/14.
 */
fun main(args: Array<String>) {
    val list = mutableListOf("a","b","c")
    list.betterSwap(1,2)
    println(list.toString())
    println(list.lastIndex)
}