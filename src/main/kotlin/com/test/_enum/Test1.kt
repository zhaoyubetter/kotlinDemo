package com.test._enum

fun main(args: Array<String>) {
    val red = Color.RED
    println(red.name)       // RED
    println(red.ordinal)    // 序号
    println(red is Color)   // 类似

    println(red.rgb())
    println(red.getCCName())

    println(Color.values()[0])  // RED
    println(Color.valueOf("RED") is Color) // true
}

/*
enum class Color {
    RED, GREEN, BLUE, YELLOW
}*/


/*
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),         // 常量创建时，指定属性值
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0);

    // 枚举类中的方法
    fun rgb() = (r * 256 + g) * 256 + b
}*/

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0) {
        override fun getCCName() = "红(red)"
    },
    GREEN(0, 255, 0) {
        override fun getCCName() = "绿(green)"
    },
    BLUE(0, 0, 255) {
        override fun getCCName() = "蓝(blue)"
    };

    // 枚举类中的方法
    fun rgb() = (r * 256 + g) * 256 + b

    // 抽象方法
    abstract fun getCCName(): String
}

