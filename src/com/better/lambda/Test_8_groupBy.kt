package com.better.lambda

fun main(args: Array<String>) {
    val list = listOf(Person("Alice", 27),
            Person("Better", 30), Person("CC", 27))
    println(list.groupBy { it.age })
}