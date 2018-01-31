package com.better.lambda

fun main(args: Array<String>) {
    val list = listOf("abc", "def")
    println(list.flatMap { it.toList() })  // a,b,c,d,e,f
    list.asSequence().map {  }
}