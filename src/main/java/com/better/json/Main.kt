package com.better.json

import com.better.json.data.MyTime
import com.better.json.data.UserBean

fun main(args: Array<String>) {
//    val c1 = County("湘潭县", 20_000)
//    val c2 = County("株洲县", 30_000)
//    val c4 = County("攸县", 40_000)
//
//    val ci1 = City("湘潭市", listOf(c1))
//    val ci2 = City("株洲市", listOf(c2, c4))
//
//    val p1 = Province("湖南省", 780, listOf(ci1, ci2))
//    println(serialize(p1))

    test2()
    test3()
}

private fun test2() {
    val user = UserBean("better", 30)
    println(serialize(user))
}

private fun test3() {
    val test = MyTime(null, "better")
    println(serialize(test))
}