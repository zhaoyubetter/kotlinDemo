package top_level

/**
 * 顶层属性
 * Created by zhaoyu on 2017/6/1.
 */
var opCount = 0     // 包级别属性声明

fun performOperation() {
    opCount++       // 改变属性值
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}