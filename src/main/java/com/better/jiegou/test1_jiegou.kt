package com.better.jiegou

data class Person(val name:String, val age:Int)

fun main(args: Array<String>) {
    val person = Person("better", 30)
    // 解构
    val (name, age) = person
    println(name)


    // 对于list
    val list = listOf(1,2,3,4,5)
    val (a,b,c) = list
}