package com.test.strings

fun main(args: Array<String>) {
    val str = """
        |Hello World
        |Hello Kotlin
        """.trimMargin(">")
    println(str)

    println("2 * 3 is ${2 * 3}")
}