package com.better.lambda

import java.util.*

fun main(args: Array<String>) {
    val list = mutableListOf<Person>()
    (0..100).forEach {
        list += Person((Random().nextInt(10 ) + 'A'.toInt()).toChar().toString(),
                (Random().nextInt(20 )))
    }

    val toList = list.asSequence()
            .map { it.name }
            .filter { it.startsWith("B") }.count()
    println(toList)
}