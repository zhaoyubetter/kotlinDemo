package cz.sample.kotlin.com.better.sign

fun main(args: Array<String>) {
    val list = listOf("Java", "Kotlin", "Js", "Python", "Swift")
    list.forEachIndexed { index, s ->
        println("$index $s")
        if(index == 2) {
            // return  // 方法返回，后面的不会执行
            return@forEachIndexed   // 这个返回没有意义
        }
    }

    println("aaa")
}