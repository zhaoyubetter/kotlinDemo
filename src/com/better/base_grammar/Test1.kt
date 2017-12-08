package com.better.base_grammar

import kotlin.*

fun main(args: kotlin.Array<String>) {
    val items = mutableListOf<kotlin.Int>(1, 5, 2, 99, 33, 0, 4)

    (1 until items.size).forEach { index ->
        val key = items[index]
        var i = index - 1
        while (i >= 0 && items[i] > key) {
            items[i + 1] = items[i]
            i--
        }
        items[i + 1] = key
    }

    println("after ${items}")
}
