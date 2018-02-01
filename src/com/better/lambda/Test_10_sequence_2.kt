package com.better.lambda

import java.util.*

fun main(args: Array<String>) {
    val list = mutableListOf<Person>()
    (0..100).forEach {
        list += Person((Random().nextInt(10 ) + 'A'.toInt()).toChar().toString(),
                (Random().nextInt(20 )))
    }

    // 惰性走，map 到 filter 为 中间操作，这个是惰性的
    // count 为末端操作，如果不执行末端操作，中间操作不会执行
    // 注意输出结果，先 map 一个，再执行 filter，再map，再filter
    val toList = list.asSequence()
            .map { println(it.name) ; it.name }
            .filter { println("haha"); it.startsWith("B") }.count()

}