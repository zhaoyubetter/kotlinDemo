package com.better.reflect

fun main(args: Array<String>) {
    println(String::class)      // 获取KClass
    println(String.javaClass)   // 获取java.lang.Class
    // 从Java切换到Kotlin的反射API
    println(String.javaClass.kotlin)
    println(String.javaClass.kotlin.simpleName)

    println("====")
    println(String::class)
    println(String::class.java)
    println(String.javaClass)
    println(String::class.javaObjectType)
    println(Byte::class.java)           // 直接类型 byte
    println(Byte::class.javaObjectType) // 包装类型 java.lang.Byte
}