package com.better.java

// 使用Java API 要特别小心，下面就是例子
fun main(args: Array<String>) {
    fun test(person:Person) {
        println(person.name?.toUpperCase())  // null pointer
    }
    test(Person(null))
}
