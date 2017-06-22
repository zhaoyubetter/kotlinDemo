package fanshe

/**
 * Created by zhaoyu on 2017/6/22.
 */
fun main(args: Array<String>) {

    // 类引用
    val c = List::class         // 获取kotlin的类引用
    println(c)
    println(List::class.java)   // 获取 Java 的类引用

    println("函数引用")

    val list = listOf(1, 2, 3, 4, 6, 7)
    println(list.filter(::isOdd))

    val list2 = listOf<String>("brillig", "b", "c")
    println(list2.filter(::isOdd))

    println("=================")
    println(strings.filter(oddLength))

}

// 函数
fun isOdd(x: Int) = x % 2 != 0

// 重载
fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"

////// 函数组合 Start
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun length(s: String) = s.length

val oddLength = compose(::isOdd, ::length)
val strings = listOf("a", "ab", "abc", "abcd")

////// 函数组合 End



