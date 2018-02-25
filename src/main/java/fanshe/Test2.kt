package fanshe

/**
 * Created by zhaoyu on 2017/6/22.
 */

var x = 1

fun main(args: Array<String>) {
    println(::x.get())  // 1
    ::x.set(2)
    println(x)  // 2

    println("======")
    val strs = listOf("a", "b", "def")
    println(strs.map(String::length))    // 属性引用
    println(strs.map { it.length }) // 等价上面的

    println("访问类的成员属性")

    val prop = A::p
    println(prop.get(A(1)))     // 输出1

    println("== 对于扩展属性 ==")
    println(String::lastChar.get("abc")) // c
}

val String.lastChar: Char
    get() = this[length - 1]

class A(val p: Int)

