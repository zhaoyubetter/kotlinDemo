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

    fun onClick() {}
}

open  class ClickListener {
    open fun onClick() {}
}

class Impl(override var name: String) : MotionListener,ClickListener() {

    override fun onClick() {
        super<ClickListener>.onClick()
        super<MotionListener>.onClick()
    }
    override fun onUp() {
    }

}