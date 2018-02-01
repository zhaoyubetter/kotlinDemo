package com.better.dsl

/**
 * Created by zhaoyu on 2018/1/27.
 */

class Getter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting , $name")
    }
}

fun main(args: Array<String>) {
    val test = Getter("Good Lock ")
    println(test("better"))     // test.invoke("better")
}