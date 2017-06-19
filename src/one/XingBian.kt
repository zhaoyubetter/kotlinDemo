package one

/**
 * Created by zhaoyu on 2017/6/18.
 */
interface Source<out T> {
    fun next(): T
}

fun demo(strs: Source<String>) {
    val objs: Source<Any> = strs
}

// 类型投影
fun copy(from: Array<out Any>, to: Array<Any>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main(args: Array<String>) {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val others: Array<Any> = arrayOf("", "2", "00")

    copy(ints, others)

    for (i in others.indices) {
        println(others[i])
    }

    //
    single<Int>(1)
}

fun <T> single(item: T): List<T>? {
    return null
}

fun <T : Comparable<T>> sort(list: List<T>) {

}

