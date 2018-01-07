package com.better.lambda.code

fun main(args: Array<String>) {
    val sum1: Int.(Int) -> Int = fun Int.(other: Int) = this + other
    println(1.sum1(22))
}
