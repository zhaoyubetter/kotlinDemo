package com.test.nothing

import java.util.concurrent.Callable

fun main(args: Array<String>) {
//    fail()
    val c: String? = null
    val ss = c ?: isNull(c)
}

fun isNull(param: Any?): Nothing {
    throw IllegalArgumentException("The param is null")
}

class NothingCallable : Callable<Nothing> {
    override fun call(): Nothing {
        var i = 10
        val lastTime = System.currentTimeMillis()
        while (i < 1000) {
            i += 10
            Thread.sleep(10)
        }
        println("cost: ${System.currentTimeMillis() - lastTime}")
        throw AssertionError("1000")
    }
}

fun fail(): Nothing {
    var i = 10
    val lastTime = System.currentTimeMillis()
    while (i < 1000) {
        i += 10
        Thread.sleep(10)
    }
    println("cost: ${System.currentTimeMillis() - lastTime}")
    throw AssertionError("1000")
}