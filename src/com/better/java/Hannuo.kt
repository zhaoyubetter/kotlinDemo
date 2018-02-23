package com.better.java

// 使用Java API 要特别小心，下面就是例子
fun main(args: Array<String>) {
//    fun test(person:Person) {
//        println(person.name?.toUpperCase())  // null pointer
//    }
//    test(Person(null))

    hanhuo(6, "A", "B", "C")
}

fun hanhuo(n:Int, x:String, y:String, z:String) {
    if(n == 0) {
        return
    }

    // 1. n - 1 from x to z use y  (n - 1)
    hanhuo(n-1, x, z, y)
    // 2. x to y
    println("$x -> $y")
    // 3. n - 1 from z to y use x (n - 1)
    hanhuo(n-1, z, y, x)
}


