package com.better.classes_and_objects.property_

/**
 * Created by zhaoyu1 on 2017/12/7.
 */
open class Foo(open val age: Int) {
    open val x: Int
        get() {
            return 1
        }
}

class Bar1(override var age: Int) : Foo(age) {
    override val x: Int = 20
}

