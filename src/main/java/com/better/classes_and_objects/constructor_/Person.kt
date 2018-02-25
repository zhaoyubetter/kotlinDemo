package com.better.classes_and_objects.constructor_

/**
 * Created by zhaoyu1 on 2017/12/6.
 */
open class Person(var name: String, var age: Int) {
    fun doSth() {}
    open fun doOthers() {
    }
}

class Student(name: String, age: Int, var score: Int) :
        Person(name, age) {
    override fun doOthers() {
        super.doOthers()
    }
}

class Teacher : Person {
    var tech: String = ""
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, tech: String) :
            this(name, age) {
        this.tech = tech
    }
}