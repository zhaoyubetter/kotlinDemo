package com.better.delegate

/**
 * 局部属性的委托 1.1 起，不好理解
 * 作用是：使一个局部变量惰性初始化
 * Created by zhaoyu on 2018/1/1.
 */

data class UserLocal(val name: String, val pwd: String) {
    fun isValid(): Boolean {
        println("isValid() called()")
        return name.equals("better") && pwd.equals("123")
    }

    fun buy() {
        println("buy() called")
    }
}

fun condition(): Boolean {
    return false
}

fun login(user: UserLocal) {
    val result by lazy { user }
    // 满足条件，才让局部变量去做事情，比如买东西
    if (condition() && result.isValid()) {
        result.buy()
    }
}

fun main(args: Array<String>) {
    val user = UserLocal("better", "123")
    login(user)

    //
}
