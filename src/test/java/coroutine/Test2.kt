package coroutine

import javafx.application.Application.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * @Description: 协程通道
 * https://www.kotlincn.net/docs/reference/coroutines/channels.html
 * @author zhaoyu1
 * @date 2019/3/29 6:07 PM
 */
class Test2 {

    // 通道基础
    @Test
    fun test1() {
        runBlocking {
            val channel = Channel<Int>()

            launch {
                // 这里可能是消耗大量 CPU 运算的异步逻辑，我们将仅仅做 5 次整数的平方并发送
                for (x in 1..5) channel.send(x * x)
            }

            // 这里我们打印了 5 次被接收的整数：
            repeat(5) { println(channel.receive()) }
            println("Done!")
        }
    }

    @Test
    fun test2() {
        runBlocking {
            val channel = Channel<Int>()
            launch {
                for (x in 1..5) channel.send(x * x)
                channel.close() // 我们结束发送
            }

            // 这里我们使用 `for` 循环来打印所有被接收到的元素（直到通道被关闭）
            for (y in channel) println(y)
            println("Done!")
        }
    }

}