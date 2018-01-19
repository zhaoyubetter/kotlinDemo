package com.better.coroutine

import java.lang.Thread.sleep
import kotlin.coroutines.experimental.buildSequence

/**
 * 协程，斐波那契数列
 * Created by zhaoyu1 on 2018/1/5.
 */
fun main(args: Array<String>) {
    val lazySeq = buildSequence {
        var i: Int = 0
        var j: Int = 1
        while (true) {
            yield(i + j)
            val tmp = i + j
            sleep(1000)
            i = j
            j = tmp
        }
    }

    //取得迭代器
    val itr = lazySeq.iterator()
    while (true) println(itr.next())
}

