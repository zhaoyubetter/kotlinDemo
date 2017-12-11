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

    val test = SortTest2()
//    test.insertSort(tmpArray)
//    test.shellSort(tmpArray)
//    test.selectionSort(tmpArray)
    test.mergeSort(tmpArray, 0, tmpArray.size - 1)
    println("目标数组：${Arrays.toString(tmpArray)}")


}

class SortTest2 {
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
                val tmp = a[i]
                a[i] = a[index]
                a[index] = tmp
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
        val tmpA = IntArray(high - low + 1)

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                tmpA[k] = a[i]
                i++
            } else {
                tmpA[k] = a[j]
                j++
            }
            k++
        }

        while (i <= mid) {
            tmpA[k++] = a[i++]
        }
        while (j <= high) {
            tmpA[k++] = a[j++]
        }

        for (k in (0..tmpA.size - 1)) {
            a[low + k] = tmpA[k]
        }
    }

    fun mergeSort(a: IntArray, low: Int, high: Int) {
        if (high > low) {
            val mid = (high + low) / 2
            mergeSort(a, low, mid)
            mergeSort(a, mid + 1, high)
            merge(a, low, mid, high)
        }
    }

    fun quickSort() {

    }
}


