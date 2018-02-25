package three

/**
 * Created by zhaoyu on 2017/5/31.
 */

// 数据类, age 默认值为 null
data class Person2(val name: String, var age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person2("better", age = 30), Person2("tom"))

    val oldest = persons.maxBy { it.age ?: 0 }  // 为 null 给0
    println("the oldest is $oldest")

    println("=====")

    val person = Person2("better", 30)
//    person.age = 31
    println(person.name)
    println(person.age)
}

/*
1.h5调用摄像头，先用大象的h5；
2.


 */