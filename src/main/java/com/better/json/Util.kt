package com.better.json

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