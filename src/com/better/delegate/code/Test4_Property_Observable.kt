package com.better.delegate.code

import kotlin.properties.Delegates

// 可观察的属性
class Test4_Property_Observable {
    var name: String by Delegates.observable("zhaoyu") { prop, old, new ->
        println("${prop.name} $old ==>$new")
    }
}

fun main(args: Array<String>) {
    val test = Test4_Property_Observable()
    println(test.name)
    test.name = "zhaoyubetter"
}