package com.better.delegate.code

// map
data class Test6_Property_map(val map:Map<String, Any?>) {
    val name:String by map      // 属性名 to key
    val pwd:String by map
}

fun main(args: Array<String>) {
    val map = mapOf("name" to "better", "pwd" to "123")
    val test = Test6_Property_map(map)
    println("${test.name} ===> ${test.pwd}")
}