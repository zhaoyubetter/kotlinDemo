package com.better.classes_and_objects.constructor_

/**
 * Created by zhaoyu1 on 2017/12/6.
 */
open class A {
    open fun doSth() {
        println("A.doSth() called...")
    }
}

interface B {
    fun doSth() {
        println("B.doSth() called...")
    }
}

class C : A(), B {
    override fun doSth() {
        super<A>.doSth()
        super<B>.doSth()
    }
}

fun main(args: Array<String>) {
    val c = C()
    c.doSth()
}