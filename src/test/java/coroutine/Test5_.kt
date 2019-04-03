package coroutine

import kotlinx.coroutines.*
import org.junit.Test

/**
 * @Description: 实战
 * @author zhaoyu1
 * @date 2019/4/1 2:24 PM
 */
class Test5_ {

    /*
    public fun CoroutineScope.launch {
        context: CoroutineContext = EmptyCoroutineContext, // 上下文
        start: CoroutineStart = CoroutineStart.DEFAULT,  // 启动模式
        block : suspend CoroutineScope.() -> Unit  // 协程体
    }


    从理论上讲，协程跟回调差别不大；
    协程的Job与Thread
     */

    @Test
    fun test() {
        GlobalScope.launch(Dispatchers.Default) {
            // 里头为线性执行
            withContext(Dispatchers.IO) {
                delay(1000L)
                println("inner")
            }

            withContext(Dispatchers.IO) {
                delay(1000L)
                println("inner2")
            }

            println("after inner println")
        }

        println("first println")
        // 防止虚拟机关闭
        Thread.sleep(3000L)
    }

    @Test
    fun test3() {
        GlobalScope.launch(Dispatchers.Default) {
            // 里头为同时执行
            launch (Dispatchers.IO) {
                delay(1000L)
                println("inner")
            }

            launch (Dispatchers.IO) {
                delay(1000L)
                println("inner2")
            }

            println("after inner println")
        }

        println("first println")
        // 防止虚拟机关闭
        Thread.sleep(3000L)
    }

    @Test
    fun test1() {
        // 1. Dispatchers.Default 为启动上下文，可实现拦截协程，比如 使用Android中年的Activity作为启动上下文
        runBlocking(Dispatchers.Default) {
            val num1 = async {
                delay(1000L)
                20
            }

            val num2 =async {
                delay(1000L)
                10
            }

            println("a")
            println(num1.await() + num2.await())
        }

        println("啦啦啦啦")
    }

    @Test
    fun testLaunch() {
        runBlocking {
            launch(Dispatchers.IO) {
                println("异步执行任务1")
                delay(1000L)

            }

            launch(Dispatchers.IO) {
                println("异步执行任务2")
                delay(1000L)
            }

            println("first println")
        }

        println("after println")
    }
}