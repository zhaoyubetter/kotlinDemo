package com.better.fanxing

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

// 泛型类
class Herd<out T : Animal> {
    val size: Int get() = 20
    //operator fun get(i:Int) : T { ... }   // 操作符重载
}

class Cat : Animal() {
    fun clean() {
    }
}

fun feedAll(animals : Herd<Animal>) {
    for(i in 0 until animals.size) {
        //animals[i].feed()
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for(i in 0 until cats.size) {
        feedAll(cats)   // 期望 Herd<Animal>
    }
}



