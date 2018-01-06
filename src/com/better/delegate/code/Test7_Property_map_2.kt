package com.better.delegate.code

data class Test7_Property_map_2(val map:Map<String, *>) {
    val name:String by map
    val pwd:String by map
    val age:Int by map
    val salary:Float? by map
}

fun main(args: Array<String>) {
    val map = mapOf("name" to "better", "pwd" to "123", "age" to 30, "salary" to null)
    val test = Test7_Property_map_2(map)
    println("${test.name} ===> ${test.pwd} ${test.age} ${test.salary}")
}