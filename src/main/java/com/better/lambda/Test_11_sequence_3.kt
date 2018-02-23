package com.better.lambda

fun main(args: Array<String>) {
    val naturalNums = generateSequence(0) { it + 1 }    // 延期操作
    val numbersTo100 = naturalNums.takeWhile { it <= 100 }  // 延期操作
    println(numbersTo100.sum()) // 获取结果时，延迟被执行


    println("abc" as? Int)

    "abc".let { println(it) }
}