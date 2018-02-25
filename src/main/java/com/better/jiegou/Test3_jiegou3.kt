package com.better.jiegou

// 可以嵌套解构

data class Person2(val name:String, val age:Int)
data class Student(val name:String, val age:Int, val p:Person2)

fun main(args: Array<String>) {

}