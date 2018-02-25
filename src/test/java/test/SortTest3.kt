package test

import java.util.*
import kotlin.system.exitProcess

/**
 * Created by zhaoyu1 on 2017/11/13.
 */

fun main(args: Array<String>) {
    val array = (0..10).map { Random().nextInt(100) }.toIntArray()
    var tmpArray = array.copyOf()
    println("原始数组：${Arrays.toString(array)}")

    val test = SortTest3()
    //test.insertSort3(tmpArray)
//    test.shellSort(tmpArray)
//    test.bubbleSort(tmpArray)
//    test.selectionSort(tmpArray)
//    test.mergeSort(tmpArray, 0, tmpArray.size - 1)
    test.quickSort(tmpArray, 0, tmpArray.size - 1)
    println("目标数组：${Arrays.toString(tmpArray)}")


}

class SortTest3 {
    fun insertSort3(a: IntArray) {
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
            for (i in (gap..a.size - 1)) {
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

    fun selectionSort(a: IntArray) {
        for (i in (0..a.size - 1)) {
            var index = i
            for (j in (i + 1..a.size - 1)) {
                if (a[j] < a[index]) {
                    index = j
                }
            }
            if (index != i) {
                val tmp = a[index]
                a[index] = a[i]
                a[i] = tmp
            }
        }
    }

    fun bubbleSort(a: IntArray) {
        for (i in (0..a.size - 1)) {
            for (j in (0..a.size - 2 - i)) {
                if (a[j] > a[j + 1]) {
                    val tmp = a[j]
                    a[j] = a[j + 1]
                    a[j + 1] = tmp
                }
            }
        }
    }

    fun merge(a: IntArray, low: Int, mid: Int, high: Int) {
        var i = low
        var j = mid + 1
        var k = 0
        var tmpArray = IntArray(high - low + 1)

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
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

    fun mergeSort(a: IntArray, low: Int, high: Int) {
        if (low < high) {
            val mid = (high + low) / 2
            mergeSort(a, low, mid)
            mergeSort(a, mid + 1, high)
            merge(a, low, mid, high)
        }
    }

    fun quickSort(a: IntArray, left: Int, right: Int) {
        if (left > right) {
            return
        }
        var i = left
        var j = right
        val base = a[left]

        while (i < j) {
            while (a[j] >= base && i < j) {
                j--
            }
            while (a[i] <= base && i < j) {
                i++
            }
            if (i < j) {
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
            }
        }

        a[left] = a[i]
        a[i] = base

        quickSort(a, left, i - 1)
        quickSort(a, i + 1, right)
    }
}


