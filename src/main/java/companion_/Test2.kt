package cz.sample.kotlin.companion_

import java.io.File


// 对象声明：创建一个类，并创建了该类的唯一实例

object FileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path)
    }
}

// 对象表达式
object StringCompator : Comparator<String> {
    override fun compare(o1: String, o2: String) = o1.compareTo(o2)
}

fun main(args: Array<String>) {
    // 不需要new实例
    println(FileComparator.compare(File("/User"), File("/user")))


    val alphas = listOf("A", "C", "F", "a", "b", "G", "#", "9", "$")
    println(alphas.sortedWith(StringCompator))


    println(alphas.sortedWith(object : Comparator<String> {
        override fun compare(o1: String, o2: String) = o2.compareTo(o1)
    }))


    // 省略写法，结合lambda
    println(alphas.sortedWith(Comparator { o1, o2 -> o2.compareTo(o1) }))


}