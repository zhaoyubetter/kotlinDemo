package coroutine

import kotlinx.coroutines.*
import org.junit.Test

/**
 * @Description: 测试3
 * https://antonioleiva.com/coroutines/
 * @author zhaoyu1
 * @date 2019/3/30 10:18 AM
 */
class Test3 {
    @Test
    fun test1() {
        runBlocking {
            val a = suspend {
                // suspend until have the result
                delay(1000L)
                20
            }

            println("正常执行...")  // 这里不会阻塞

            val b = suspend {
                100 + a.invoke()
            }

            println(b.invoke())
        }
    }

    /**
     * coroutine context
     */
    @Test
    fun test2() {
        // 执行协程执行环境, suspend时，会发生什么
        runBlocking(Dispatchers.Default) {

            val a = withContext(Dispatchers.IO) {
                println(Thread.currentThread().name)
                delay(3000L)
                20
            }


            // 等待a先执行
            val b = withContext(Dispatchers.IO) {
                println(Thread.currentThread().name)
                10
            }


            withContext(Dispatchers.Default) {
                println(Thread.currentThread().name)
                println(a + b)
            }
        }

        // 一直阻塞到结束
        println("after")  // 最后打印
    }

    /**
     * Dispatchers
     */
    @Test
    fun test3() {
        // 各种 dispatchers 区别
    }

    /**
     * Coroutine Builder
     * it won’t block the current thread (if we use the proper dispatchers, of course).
     */
    @Test
    fun test4() {
        val mainJob = GlobalScope.launch(Dispatchers.Default) {
            val job = GlobalScope.launch {
                delay(1000L)
                println("World!")
            }

            println("ok")   // 执行
            job.join()      // 等待job执行结束
        }

        println("取消任务...")
        mainJob.cancel()    // 取消任务。其子任务也会取消

        Thread.sleep(2000L)
    }

    /**
     * 以下为顺序执行，test6 修正此问题，实现一起执行
     */
    @Test
    fun test5() {
        GlobalScope.launch {

            // 耗时2s
            val noA = withContext(Dispatchers.IO) {
                println(Thread.currentThread().name)
                delay(2000L)
                20
            }

            // 耗时1s
            val noB = withContext(Dispatchers.IO) {
                println(Thread.currentThread().name)
                delay(1000L)
                10
            }

            // 耗时 0.2s
            val sum = withContext(Dispatchers.IO) {
                println(Thread.currentThread().name)
                delay(200L)
                noA + noB
            }

            println("result: $sum")  // 协程总耗时：
        }

        Thread.sleep(7000L)  // 避免jvm提前退出 (2+1+0.2)s
    }

    /**
     * async
     */
    @Test
    fun test6() {
        GlobalScope.launch {

            // 同步 - 生成被减数
            val minuend = withContext(Dispatchers.IO) {
                println(Thread.currentThread().name)
                delay(2000L)
                20
            }

            // 异步生成减数1
            val noA = async (Dispatchers.IO) {
                println("异步生成减数1：" + Thread.currentThread().name)
                delay(1000L)
                10
            }

            // 异步生成减数2
            val noB = async(Dispatchers.IO) {
                println("异步生成减数2：" + Thread.currentThread().name)
                delay(500L)
                5
            }

            println("result: ${minuend - noA.await() - noB.await()}")  // 协程总耗时：
        }

        Thread.sleep(4000L)  // 避免jvm提前退出 (2+1+0.2)s
    }
}