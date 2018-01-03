package com.better.delegate

import kotlin.reflect.KProperty

/**
 * 属性委托
 * https://www.jianshu.com/p/306bdc2bac3f
 * Created by zhaoyu on 2018/1/1.
 */
class Example {
    // 属性的 set get 委托到 setValue 与 getValue
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, '${property.name}' to me"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value assigned to '${property.name} in $thisRef'")
    }
}

fun main(args: Array<String>) {
    val e = Example()
    // 监听属性的 get 与 set
    println(e.p)
    e.p = "better"
}