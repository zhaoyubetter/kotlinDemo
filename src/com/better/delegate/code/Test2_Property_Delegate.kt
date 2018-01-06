package com.better.delegate.code

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 委托属性例子
 **/
class Baby {
    var name:String by Delegate()
}

class Delegate{
    operator fun getValue(thisRef : Any?, property: KProperty<*> ):String {
        return ("$thisRef delegating ${property.name}")
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:String) {
        println("$value has been assigned to ${property.name} in ${thisRef}")
    }
}

fun main(args: Array<String>) {
    val baby = Baby()
    println(baby.name)      // 访问委托类的getValue()
    baby.name = "better"    // 访问委托类的setValue()
    println(baby.name)
}
