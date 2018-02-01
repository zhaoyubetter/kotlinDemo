package com.better.dsl

/**
 * Created by zhaoyu on 2018/1/27.
 */

class DenpenderyHandler {
    fun compile(coordinate: String) {
        println("add dependency on $coordinate")
    }
    operator fun invoke(body: DenpenderyHandler.() -> Unit) {
        body()
    }
}

fun main(args: Array<String>) {
    val dep = DenpenderyHandler()
    dep.compile("com.git.basenet:basenet:0.0.7")
    dep {
        compile("com.git.basenet:basenet:0.0.7")
    }
}