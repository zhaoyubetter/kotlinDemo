package com.better.json

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

fun <T> Iterable<T>.joinToStringBuilder(sb: StringBuilder, separator: CharSequence = ", ", prefix: CharSequence = "",
                                        postfix: CharSequence = "", limit: Int = -1,
                                        truncated: CharSequence = "...",
                                        transform: ((T) -> Unit)? = null): StringBuilder {
    return joinTo(sb, separator, prefix, postfix, limit, truncated) {
        if (transform != null) {
            transform.invoke(it)
            return@joinTo ""
        }
        it.toString()
    }
}



// 反序列化添加
fun Type.isPrimitiveOrString(): Boolean {
    val cls = this as? Class<Any> ?: return false
    return cls.kotlin.javaPrimitiveType != null || cls == String::class.java
}

fun Type.asJavaClass(): Class<Any> = when (this) {
    is Class<*> -> this as Class<Any>
    is ParameterizedType -> rawType as? Class<Any>
            ?: throw UnsupportedOperationException("Unknown type $this")
    else -> throw UnsupportedOperationException("Unknown type $this")
}