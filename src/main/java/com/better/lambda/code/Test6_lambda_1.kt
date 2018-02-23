package com.better.lambda.code

/**
 * Created by zhaoyu on 2018/2/1.
 */

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println(result)
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (a in this) {
        if (predicate(a)) {
            sb.append(a)
        }
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    twoAndThree { i, j -> i + j }
    twoAndThree({ i, j -> i * j })

    ///========
    val str = "abcdebbbjkl567".filter { it in 'a'..'z' }
    println(str)
}