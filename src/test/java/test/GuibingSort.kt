package test

import java.util.*

/**
 * Created by zhaoyu1 on 2017/11/13.
 */
fun main(args: Array<String>) {
    val array = (0..10).map { Random().nextInt(100) }.toIntArray()
    var tmpArray = array.copyOf()
    println("原始数组：${Arrays.toString(array)}")

//    mergeSort(tmpArray, 0, tmpArray.size - 1)
//    println("排序后：${Arrays.toString(tmpArray)}")

//    selectionSort(tmpArray)
    //insertSort(tmpArray)
    //shellSort(tmpArray)
//    mergeSort(tmpArray, 0, tmpArray.size - 1)
    bubbleSort(tmpArray)

    println("目标数组：${Arrays.toString(tmpArray)}")
}

fun bubbleSort(a: IntArray) {
    for (i in (0..a.size - 1)) {
        for (j in (0..a.size - i - 2)) {
            if (a[j + 1] < a[j]) {
                val tmp = a[j + 1]
                a[j + 1] = a[j]
                a[j] = tmp
            }
        }
    }
}


fun selectionSort(array: IntArray) {
    for (i in (0..array.size - 1)) {
        var index = i
        for (j in (i + 1..array.size - 1)) {
            if (array[j] < array[index]) {
                index = j
            }
        }
        if (index != i) {
            val tmp = array[i]
            array[i] = array[index]
            array[index] = tmp
        }
    }
}

fun insertSort(a: IntArray) {
    for (i in (1..a.size - 1)) {
        val key = a[i]
        var index = i - 1
        while (index >= 0 && a[index] > key) {
            a[index + 1] = a[index]
            index--
        }
        a[index + 1] = key
    }
}

fun shellSort(a: IntArray) {
    var gap = a.size / 2
    while (gap > 0) {
        for (i in (gap..a.size - 1) step gap) {
            val key = a[i]
            var index = i - gap
            while (index >= 0 && a[index] > key) {
                a[index + gap] = a[index]
                index -= gap
            }
            a[index + gap] = key
        }
        gap /= 2
    }
}

fun mergeSort(a: IntArray, low: Int, high: Int) {
    if (high > low) {
        val mid = (low + high) / 2
        mergeSort(a, low, mid)
        mergeSort(a, mid + 1, high)
        merge(a = a, low = low, mid = mid, high = high)
    }
}

fun merge(a: IntArray, low: Int, mid: Int, high: Int) {
    var i = low
    var j = mid + 1
    var k = 0
    var tmpArray = IntArray(high - low + 1)

    while (i <= mid && j <= high) {
        if (a[i] <= a[j]) {
            tmpArray[k] = a[i]
            i++
        } else {
            tmpArray[k] = a[j]
            j++
        }
        k++
    }

    while (i <= mid) {
        tmpArray[k++] = a[i++]
    }
    while (j <= high) {
        tmpArray[k++] = a[j++]
    }

    for (k in (0..tmpArray.size - 1)) {
        a[low + k] = tmpArray[k]
    }
}

