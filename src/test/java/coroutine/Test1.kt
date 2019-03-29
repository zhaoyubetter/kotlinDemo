package coroutine

import kotlinx.coroutines.*
import org.junit.Test

/**
 * @Description: 协程基础测试
 * @author zhaoyu1
 * @date 2019/3/29 2:52 PM
 */
class Test1 {

    @Test
    fun test1() {
        runBlocking {
            val job = GlobalScope.launch {
                delay(1000L)
                println("World!")
            }
            println("Hello,")
            job.join() // 等待知道子协程执行结束
        }
    }

    /**
     * 【结构化并发】
     * 去掉最顶层的协程 GlobalScope
     * 结构化并发，在指定作用域内启动协程
     */
    @Test
    fun test2() {
        runBlocking {
            launch {
                delay(1000L)
                println("World!")
            }
            println("Hello, ")
        }
    }

    /**
     * 作用域构建器
     */
    @Test
    fun test3() {
        runBlocking {

            launch {
                delay(200L)
                println("Task from runBlocking")
            }

            // 创建一个新的协程作用域
            coroutineScope {
                launch {
                    delay(500L)
                    println("Task from nested launch!")
                }

                delay(100L)
                println("Task from coroutine scope")  //
            }

            println("Coroutine scope is over")
        }
    }

    /**
     * 提取函数重构
     */
    @Test
    fun test4() {
        // 挂起函数
        suspend fun doWorld() {
            delay(1000L)
            println("World.")
        }

        runBlocking {
            launch { doWorld() }
            println("Hello,")
        }
    }
}