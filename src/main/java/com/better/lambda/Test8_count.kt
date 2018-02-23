package com.better.lambda

data class Person(val name:String, val age:Int)

fun main(args: Array<String>) {
    val list = listOf(Person("Alice", 27), Person("Better", 30))
    val more27 = {p:Person -> p.age > 27}
    println(list.count(more27))
    println(list.filter(more27).size)
}