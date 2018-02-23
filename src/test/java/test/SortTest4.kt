package test

import java.util.*

/**
 * Created by zhaoyu1 on 2017/11/13.
 */

fun main(args: Array<String>) {
    val array = intArrayOf(44, 22, 30, 65, 5, 33, 46, 53, 18, 55, 85)
    var tmpArray = array.copyOf()
    println("原始数组：${Arrays.toString(array)}")

    val test = SortTest4()
    test.radixSort3(tmpArray, 2)
    println("目标数组：${Arrays.toString(tmpArray)}")
}

class SortTest4 {
    fun headSort(a: IntArray) {
        for (i in (a.size / 2 downTo 0)) {
            buildHeap(a, i, a.size - 1)
        }
        for (i in (a.size - 2 downTo 1)) {
            val tmp = a[i]
            a[i] = a[0]
            a[0] = tmp
            buildHeap(a, 0, i)
        }
    }

    fun buildHeap(a: IntArray, parent: Int, length: Int) {
        val key = a[parent]
        var i = parent
        var left = 2 * i + 1
        while (left < length) {
            if (left + 1 < length && a[left + 1] > a[left]) {
                left++
            }
            if (key >= a[left]) {
                break
            }
            a[i] = a[left]
            i = left
            left = 2 * i + 1
        }
        a[i] = key
    }

    fun quickSort(a: IntArray, left: Int, right: Int) {
        if (left > right) {
            return
        }
        val key = a[left]
        var i = left
        var j = right
        while (i < j) {
            while (a[j] >= key && i < j) {
                j--
            }
            while (a[i] <= key && i < j) {
                i++
            }
            if (i < j) {
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
            }
        }

        a[left] = a[i]
        a[i] = key
        quickSort(a, left, i - 1)
        quickSort(a, i + 1, right)
    }

    fun insertSort(a: IntArray) {
        for (i in (1..a.size - 1)) {
        }
    }

    fun radixSort(array: IntArray, radix: Int) {
        // 0:
        // 1:
        // 2:
        // 3:
        // 4:
        // 5:
        // 6:
        // 7:
        // 8:
        // 9:
        val order = IntArray(10)
        val bucketArray = Array(10) { IntArray(array.size) }
        var times = 1
        for (i in (0..radix - 1)) {
            //分桶
            array.forEach {
                val key = it / times % 10
                bucketArray[key][order[key]] = it
                order[key]++
            }
            // printBucket(bucketArray)
            var k = 0
            bucketArray.forEachIndexed { index, arr ->
                if (0 < order[index]) {
                    for (j in (0..order[index] - 1)) {
                        array[k++] = arr[j]
                    }
                    order[index] = 0
                }
            }
            times *= 10
        }
    }

    fun printBucket(bucketArray: Array<IntArray>) {
        for (i in (0..bucketArray.size - 1)) {
            println("$i : ${Arrays.toString(bucketArray.get(i))}")
        }
    }


    fun radixSort3(a: IntArray, radix: Int) {
        val counter = IntArray(10)      // 记录桶中数的个数
        val bucketArray = Array(10) { IntArray(a.size) }  // 2维数组
        var digit = 1
        for (i in (0..radix - 1)) {
            // 装桶
            a.forEach { it ->
                val key = it / digit % 10
                bucketArray[key][counter[key]] = it
                counter[key]++
            }

            // 倒出来
            var k = 0
            bucketArray.forEachIndexed { index, arr ->
                if (0 < counter[index]) {
                    (0..counter[index]-1).forEach {
                        a[k++] = arr[it]
                    }
                    counter[index] = 0
                }
            }
            digit *= 10
        }
    }

}


