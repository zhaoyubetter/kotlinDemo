package com.test.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Description:
 * @author zhaoyu1
 * @date 2019/3/29 2:35 PM
 */
fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello, ")  //
    delay(2000L)  // 延迟2s保证jvm存活
}