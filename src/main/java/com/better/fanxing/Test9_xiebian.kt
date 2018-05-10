package com.better.fanxing

import com.better.reflect.Anim

/**
 * 协变
 * Created by zhaoyu on 2018/2/3.
 */

fun main(args: Array<String>) {

}

open class Animal {
    fun feed() {
    }
}

// 泛型类,牲畜类
class Herd<T : Animal> {        // class Herd<T : Animal>
    val size: Int get() = 20
    val list = listOf<T>()
    operator fun get(i:Int) : T { return list[i] }   // 操作符重载
}

// 猫
class Cat : Animal() {
    fun clean() {}
}

fun feedAll(animals : Herd<Animal>) {
    for(i in 0 until animals.size) {
        animals[i].feed()   // 调用feed
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for(i in 0 until cats.size) {
        cats[i].clean()
//        feedAll(cats as Herd<Animal>)
//        feedAll(cats)   // 期望 Herd<Animal>
    }
}



