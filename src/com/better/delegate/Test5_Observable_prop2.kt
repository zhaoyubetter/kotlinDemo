package com.better.delegate

import kotlin.properties.Delegates

/**
 * 可观察的属性
 * Created by zhaoyu on 2017/6/19.
 */
class UserBean {
    var name: String by Delegates.vetoable("<empty>") {
        prop, old, new ->
        println("$old -> $new")
        new.length > 3
    }
}

fun main(args: Array<String>) {
    val user = UserBean()
    user.name = "ab"        // 没有没有赋值成功
    user.name = "best"
    println(user.name)
}