package com.better.reflect

import kotlin.reflect.full.memberProperties

open class Anim(val typeName:String)

class Person(val name:String, val age:Int):Anim("huminbeans") {
    fun method() {
        println("method called()")
    }
}

fun main(args: Array<String>) {
    val person = Person("better", 30)
    val kClass = person.javaClass.kotlin

    // 反射訪問所有非擴展屬性(包括父)
    kClass.memberProperties.forEach {
        println(it.name)        // KProperty
    }

}