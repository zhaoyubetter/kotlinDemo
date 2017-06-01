package one

/**
 * 局部变量
 * Created by zhaoyu on 2017/5/26.
 */

fun main(args: Array<String>) {
    // 局部变量
    val a: Int = 1     // val 定位的变量为final类型
    val b = 2
    val c: Int
    c = 3

    println("a = $a, b = $b, c = $c")

    var i = 1       // var 定义的为可变变量
    val s1 = "i is $i"
    i = 2
    val s2 = "${s1.replace("is", "was")}, but now is $i"
    println(s2)
}
