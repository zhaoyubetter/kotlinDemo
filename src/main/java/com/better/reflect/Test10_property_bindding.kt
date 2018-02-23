package com.better.reflect

fun main(args: Array<String>) {

    val prop = "abcde"::length
    println(prop.get())

    //

    val list = listOf("aa","bb","cc")
    val sb = StringBuilder()
    list.joinToString( ",", "[", "]") {
        it
    }
}