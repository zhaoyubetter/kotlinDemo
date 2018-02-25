package com.better.fanxing

/**
 * Created by zhaoyu on 2018/2/3.
 */

fun printContents(c: List<Any>) {
    println(c.joinToString(""))
}

fun addContent(list: MutableList<Any>) {
    list.add(1234)
}

fun main(args: Array<String>) {
    printContents(listOf("a","b"))

    //===========
    val list = mutableListOf<String>("cccc")
//    addContent("bbbb")
}