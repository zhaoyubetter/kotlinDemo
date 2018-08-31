package com.better.dsl


val muFun = fun(sb: StringBuilder) {
    for (a in 'a'..'z') {
        sb.append(a)
    }
}

fun main(args: Array<String>) {
    val l = StringBuilder().apply {
        for (a in 'a'..'z') {
            append(a)
        }
    }.toString()
    println(l)
}
