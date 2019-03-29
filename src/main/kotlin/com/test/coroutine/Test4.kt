package com.test.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Description: 等待一个作业
 * 延迟一段时间来等待另一个协程运行并不是一个好的选择
 * @author zhaoyu1
 * @date 2019/3/29 2:41 PM
 */

fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    job.join() // 等待知道子协程执行结束
}