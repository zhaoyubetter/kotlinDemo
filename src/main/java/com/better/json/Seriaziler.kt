package com.better.json

import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

/*
 获取类的所有KProperty;
遍历 KProperty 集合，获取每个 KProperty；
每个KProperty都有他的名字与值，对应json的 key，value，value 处理时，需进行类型判断；
 */

fun serialize(o: Any) = buildString { serializeObj(o) }

private inline fun StringBuilder.serializeObj(o: Any) {
    o.javaClass.kotlin.memberProperties
            .filter { it.findAnnotation<JsonExclude>() == null }
            .joinToStringBuilder(this, separator = ",", prefix = "{", postfix = "}") {
                serializeProperty(it, o)
            }
}

private inline fun StringBuilder.serializeProperty(property: KProperty1<Any, *>, receiver: Any) {
    // has change name
    val jsonName = property.findAnnotation<JsonName>()?.name ?: property.name
    serializeString(jsonName)
    append(":")

    val value = property.invoke(receiver)
    val jsonValue = property.getCustomSerializer()?.toJsonValue(value) ?: value
    serializePropertyValue(jsonValue)
}

fun KProperty<*>.getCustomSerializer(): ValueSerializer<Any?>? {
    // has custom serialize
    val customSerializeClass = findAnnotation<CustomSerializer>()?.kClazz
    if (customSerializeClass != null) {
        // 创建KClass 示例
        val valueSerializer = customSerializeClass.objectInstance ?: customSerializeClass.createInstance()
        // * 需要强制转一下
        return (valueSerializer as ValueSerializer<Any?>?)
    }
    return null
}

private fun StringBuilder.serializePropertyValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> serializeString(value)
        is Boolean, is Number -> append(value.toString())
        is Collection<*> -> serializeCollection(value)
        is Map<*,*> -> serializeMap(value)
        else -> serializeObj(value)
    }
}

private fun StringBuilder.serializeCollection(data: Collection<Any?>) {
    data.joinToStringBuilder(this, separator = ", ", prefix = "[", postfix = "]") {
        serializePropertyValue(it)
    }
}

/**
 * Map 实际上是一个 Object
 */
private fun StringBuilder.serializeMap(data: Map<*, *>) {
    data.entries.joinToStringBuilder(this, separator = ", ", prefix = "{", postfix = "}") { it ->
        serializeString(it.key.toString())       // force to String
        append(":")
        serializePropertyValue(it.value as Any)
    }
}

private fun StringBuilder.serializeString(data: String) {
    append("\"").append(data).append("\"")
}

