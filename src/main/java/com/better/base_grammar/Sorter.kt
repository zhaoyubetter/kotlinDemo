package com.better.base_grammar

import java.util.*

/**
 * Created by zhaoyu1 on 2017/12/1.
 */

fun main(args: Array<String>) {
    val array = intArrayOf(10, 9, 67, 87, 55, 33, 22, 12, 17, 88)
    println("before sort: ${Arrays.toString(array)}")
    shellSort(array)
    println("after  sort: ${Arrays.toString(array)}")
}

fun swap(array: IntArray, i: Int, j: Int) {
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}

fun bubbleSort(array: IntArray) {
    for (i in 0 until array.size) {
        for (j in (array.size - 1 downTo 1)) {
            if (array[j] < array[j - 1]) {
                swap(array, j, j - 1)
            }
        }
    }
}

fun insertSort(array: IntArray) {
    (1 until array.size).forEach { i ->
        val key = array[i]
        var index = i - 1
        while (index >= 0 && array[index] > key) {
            array[index + 1] = array[index]
            index--
        }
        array[index + 1] = key
    }
}

fun shellSort(array: IntArray) {
    var gap = array.size / 2
    while (gap > 0) {
        (gap until array.size).forEach { it ->
            val key = array[it]
            var index = it - gap
            while (index >= 0 && array[index] > key) {
                array[index + gap] = array[index]
                index -= gap
            }
            array[index + gap] = key
        }
        gap /= 2
    }
}

