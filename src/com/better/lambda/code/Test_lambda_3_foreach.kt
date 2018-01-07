package com.better.lambda.code

import others.map

fun main(args: Array<String>) {
    val map = mapOf(1 to "one",2 to "two",3 to "three")
    map.forEach{ it ->
        println("${it.key} ---> ${it.value}")
    }

    // 下划线，不使用该变量
    map.forEach { _, u ->
        println("${u} ")
    }
}