package com.better.delegate

import kotlin.properties.Delegates

/**
 * 可观察的属性
 * Created by zhaoyu on 2017/6/19.
 */
class User {
    var name: String by Delegates.observable("<empty>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "better"
    user.name = "best"
}