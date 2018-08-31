package com.test.clazz

/*
class User(var name: String = "better") {    // 主构造
    var age: Int = 0
        get() = if (field < 0) 0 else field
        set(value) {
            field = if (value < 0) 0 else value
        }
}

abstract class Animator {
    // 抽象属性，可以允许val
    abstract val duration: Int
    fun startAnim() {
    }
    abstract fun setInterceptor()
}

class PropertyAnimator() : Animator() {
    override val duration = 800
    override fun setInterceptor() {
    }
}*/

class Outter {
    private val name = "better"
    inner class Inner {
        val age = 1
        init {
            println(name)   // 访问外部类对象
        }
    }
}

fun main(args: Array<String>) {
    val inner = Outter().Inner()
    println(inner.age)
}
