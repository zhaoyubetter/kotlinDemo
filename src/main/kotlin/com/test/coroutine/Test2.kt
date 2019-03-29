package com.test.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Description:
 * @author zhaoyu1
 * @date 2019/3/29 2:33 PM
 */
fun main(args: Array<String>) {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello ")
    // 阻塞主线程
    runBlocking {
        delay(2000L)
    }
}