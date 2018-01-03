package com.better.clazz.data.sealed

/**
 * Created by zhaoyu1 on 2017/12/27.
 */
sealed class SealedClass {
    data class Dog(val name:String):SealedClass()
}