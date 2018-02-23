package com.better.`object`

/**
 * 单利的支持 object
 * Created by zhaoyu on 2017/12/31.
 */

class Person

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (p in allEmployees) {

        }
    }
}

// 单例的做法
object CaseInsensitiveComparator : Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        return o1.compareTo(o2, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveComparator.compare("abc", "ABC"))
    val list = listOf<String>("a","d", "b","g", "c")
    println(list.sortedWith(CaseInsensitiveComparator))
}