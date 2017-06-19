package by_

import kotlin.reflect.KProperty

/**
 * Created by zhaoyu1 on 2017/6/19.
 */
class Example {
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

