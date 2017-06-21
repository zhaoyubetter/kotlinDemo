package gaojie

/**
 * 接收者对象
 * Created by zhaoyu on 2017/6/20.
 */


val sum = fun Int.(other: Int): Int = this + other

fun main(args: Array<String>) {
    println(sum(2, 2))  // 4

}
