package com.better.json

import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties


/**
 * to json
 */
fun toJson(obj: Any): String {
    val kClass:KClass<Any> = obj.javaClass.kotlin
    val kProperties = kClass.memberProperties

    return kProperties.joinToString(separator = ",", prefix = "{", postfix = "}") {
        it-> serializeProperty(it, obj)
    }
}


fun serializeProperty(prop:KProperty1<Any, *>, obj:Any):String {
    // key
    val sb = StringBuilder()
    sb.serializeString(prop.name)

    sb.append(": ")

    // value
    val propValue = prop.get(obj)
    when(propValue) {
        null -> sb.append("null")
        is String -> sb.serializeString(propValue)
        is Number, is Boolean -> sb.append(propValue)
        // is List<*> ->

    }
    return sb.toString()
}

// "name"
fun StringBuilder.serializeString(s:String) {
    append("\"")
    append(s)
    append("\"")
}


fun main(args: Array<String>) {
    val p = Person("better", 30)
    println(toJson(p))
}

data class Person(val name: String, val age: Int)