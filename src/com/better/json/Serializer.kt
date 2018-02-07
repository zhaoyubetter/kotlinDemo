package com.better.json

import others.list
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

/**
 * Created by zhaoyu on 2018/2/7.
 */

// 对外全局方法
fun serialize(obj: Any) = buildString { serializeObj(obj) }

private inline fun StringBuilder.serializeObj(o: Any) {
    // ==== 1. 获取类的所有`KProperty`
    o.javaClass.kotlin.memberProperties.joinToStringBuilder(this, separator = ",", prefix = "{", postfix = "}") {
        // ==== 2.遍历 `KProperty` 集合，获取每个 `KProperty`，进行类型判断，并处理；
        serializeProperty(it, o)
    }
}

private inline fun StringBuilder.serializeProperty(property: KProperty1<Any, *>, receiver: Any) {
    // ====3. 每个`KProperty`都有他的名字与值，对应json的 key，value，value 处理时，需进行类型判断；
    val key = property.name
    // 处理key
    serializeString(key)
    append(": ")

    // 处理value
    val value = property.get(receiver)
    serializePropertyValue(value)
}


/**
 * 处理list
 */
private fun StringBuilder.serializeList(data: List<Any?>) {
    data.joinToStringBuilder(this, separator = ", ", prefix = "[", postfix = "]") {
        serializePropertyValue(it)
    }
}

private fun StringBuilder.serializePropertyValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> serializeString(value)
        is Boolean, is Number -> append(value.toString())
        is List<*> -> serializeList(value)
        else -> serializeObj(value)
    }
}

private inline fun StringBuilder.serializeString(name: String) {
    // like "better"
    append('\"').append("$name").append('\"')
}

fun <T> Iterable<T>.joinToStringBuilder(sb: StringBuilder, separator: CharSequence = ", ",
                                        prefix: CharSequence = "",
                                        postfix: CharSequence = "",
                                        limit: Int = -1,
                                        truncated: CharSequence = "...",
                                        transform: ((T) -> Unit)? = null): StringBuilder {
    return joinTo(sb, separator, prefix, postfix, limit, truncated) {
        if (transform == null) {    // 包装器模式
            return@joinTo it.toString()
        }
        transform.invoke(it)
        ""
    }
}

fun main(args: Array<String>) {
    // 县
    data class County(val name: String, val peopleCount: Int)
    // 市
    data class City(val name: String, val counties: List<County>)
    // 省
    data class Province(val name: String, val size: Int, val cities: List<City>?)

    val c1 = County("湘潭县", 20_000)
    val c2 = County("株洲县", 30_000)
    val c4 = County("攸县", 40_000)


    val ci1 = City("湘潭市", listOf(c1))
    val ci2 = City("株洲市", listOf(c2, c4))

    val p1 = Province("湖南省", 780, listOf(ci1, ci2))
    println(serialize(p1))
}