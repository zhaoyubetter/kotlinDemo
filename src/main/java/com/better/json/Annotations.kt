package com.better.json

import kotlin.reflect.KClass

/**
 * 排除
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonExclude

/**
 * 替换名字
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonName(val name: String)

/**
 * 自定义转换器
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
// ValueSerializer 协变，表示 ValueSerializer 的子类
annotation class CustomSerializer(val kClazz: KClass<out ValueSerializer<*>>)

interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?

    fun fromJsonValue(jsonValue: Any?): T
}




/*==== 反序列化 ======*/
@Target(AnnotationTarget.PROPERTY)
annotation class DeserializeInterface(val targetClass: KClass<out Any>)