package com.better.classes_and_objects.interface_

/**
 * Created by zhaoyu1 on 2017/12/7.
 */
interface MotionListener {
    var name: String
    fun onMove() {
        println("onMoving")
    }

    fun onUp()
}

class Impl(override var name: String) : MotionListener {
    override fun onUp() {
    }
}