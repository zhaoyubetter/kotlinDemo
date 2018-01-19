package com.better.classes_and_objects

import java.beans.AppletInitializer

/**
 * Created by zhaoyu1 on 2017/12/4.
 */
class Person constructor(name: String) {        // private constructor 反编译代码
    var name: String = name
        get() = field.toUpperCase()

    val lastName: String = "zhao"
        get() = field.toUpperCase()

    var no: Int = 10
        get() = field
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1          // 如果传入的值大于等于 10 返回 -1
            }
        }
}

class LazyProperty(val initializer: () -> String) {
    var nameValue: String? = null
    val  name: String
    get()
    {
        if (nameValue == null) {
            nameValue = initializer()
        }
        return nameValue!!
    }

}

fun main(args: Array<String>) {
    val person = Person("better")
    println(person.name)
    println(person.lastName)
    person.no = 8
    println(person.no)

    println("========================")
    val lazy = LazyProperty({ "better" })
    println(lazy.name)
}


// class Person (name:String){}
