package com.better.classes_and_objects

/**
 * Created by zhaoyu1 on 2017/12/4.
 */
open class Base(p: Int) {
    open fun foo() = println("${this.javaClass.toString()}")

    var p: Int = 0

    init {
        println("${p}")
        this.p = p
    }
}

class Child(p: Int) : Base(p) {
    constructor(p: Int, p2: Int) : this(p) {
        this.p2 = p2
    }

    var p2: Int = 0

    override fun foo() {
        super.foo()
        println("p is, p2 is ${p2}")
    }
}

class Outer {
    private val bar: Int = 1
    var prop = "成员属性"

    inner class Inner {
        fun test() = bar    // 直接访问外部类成员
        fun innserTest() {
            var outer = this@Outer
            println("访问外部类成员，${outer.prop}")
        }
    }
}


fun main(args: Array<String>) {
    val base = Child(2, 3)
    println(base.foo())

    println("&&&&&&&&&&&&&&&&&&&&&")
    val outer = Outer()
    val inner = outer.Inner()
    println(inner.innserTest())
}

