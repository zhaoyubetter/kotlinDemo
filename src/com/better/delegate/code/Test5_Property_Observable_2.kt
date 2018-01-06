package com.better.delegate.code

import kotlin.properties.Delegates

// 可观察的属性
class Test5_Property_Observable_2 {
    var name: String by Delegates.vetoable("zhaoyu") { prop, old, new ->
        if (new == "ergouzi") {
            println("fuck!!! the name is not appropriate")
            return@vetoable false   // 局部返回，我们后面会说的，先别着急
        }
        return@vetoable true
    }
}

fun main(args: Array<String>) {
    val test = Test5_Property_Observable_2()
    println(test.name)
    test.name = "ergouzi"
    println(test.name)
}