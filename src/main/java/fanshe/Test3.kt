package fanshe

/**
 * 构造函数引用
 * Created by zhaoyu on 2017/6/22.
 */

data class Person(val name: String)

fun main(args: Array<String>) {
    val p = ::Person            // 构造函数的引用
    val person = p("better")

    println(person.name)
}