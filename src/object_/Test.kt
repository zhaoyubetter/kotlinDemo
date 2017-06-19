package object_

/**
 * 对单例模式的支持
 * Created by zhaoyu1 on 2017/6/2.
 */
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (p in allEmployees) {

        }
    }
}

class Person

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