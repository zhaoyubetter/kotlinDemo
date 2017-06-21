package gaojie

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * 高阶函数
 * Created by zhaoyu on 2017/6/20.
 */

// body 是函数类型
inline fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()      // 执行
    } finally {
        lock.unlock()
    }
}

fun add(x: Int, y: Int) = x + y

fun main(args: Array<String>) {
    val lock: Lock = ReentrantLock()
    println(lock(lock, { add(5, 6) }))

    lock(lock) {add(5,6) }


    println("====== map == ")
    val list = arrayListOf<Int>(1, 2, 3, 4, 5)
    val doubles = list.map { value -> value * 2 }
    for (a in doubles) {
        println(a)
    }

    val three = list.map() { it * 3 }
    for (a in three)
        println(a)


    // 匿名函数
    var fours = list.map(fun(item) = item * 4)



    println("====== real map == ")
    val map = mapOf("a" to 1, "b" to 2)
    map.forEach { _, u -> println("$u") }

}
