package com.better.lambda.code

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,6,7,8)
    list.map { x:Int -> x * 2 }
    list.map {x -> x * 2}
}