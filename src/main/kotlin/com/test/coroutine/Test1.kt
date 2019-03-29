package com.test.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @Description: 协程测试1
 * 参考：https://www.kotlincn.net/docs/reference/coroutines/basics.html
 * @author zhaoyu1
 * @date 2019/3/29 2:22 PM
 */

fun main(args: Array<String>) {
    GlobalScope.launch {   // 后台启动一个协程
        delay(1000L)  // 非阻塞等待1s
        println("World!")
    }

    print("Hello, ")   // 协程等待，主线程继续
    Thread.sleep(2000L)
}