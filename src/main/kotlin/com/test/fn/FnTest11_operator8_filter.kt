package com.test.fn

/**
 * filterTo
 */
fun main(args: Array<String>) {
    val list1 = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 10)
    val list2 = list1.map { it * 10 }
    val list3 = list2.map { it * 10 }
    val listTotal = mutableListOf<Int>()

    list1.filterTo(listTotal) { it % 2 == 0 }
    list2.filterTo(listTotal) { it % 2 == 0 }
    list3.filterTo(listTotal) { it % 2 == 0 }

    println(listTotal.toString())

    listTotal.filterIndexed()
}