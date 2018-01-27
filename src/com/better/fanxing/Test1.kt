package com.better.fanxing

/**
 * Created by zhaoyu on 2018/1/19.
 */

fun main(args: Array<String>) {

    val no_gravity = 0x0000         // 0000     0
    val axis_specified = 0x0001     // 0001     1   // 轴指定
    val axis_pull_before = 0x0002   // 0010     2
    val axis_pull_after = 0x0004    // 0100     4
    val axis_clip = 0x0008          // 1000     8

    // 位移大小
    val axis_x_shift = 0        // x轴方向
    val axis_y_shift = 4        // y轴方向

    // 4个方位
    val left = axis_pull_before or axis_specified shl axis_x_shift      // 0000 0011  (3)
    val right = axis_pull_after or axis_specified shl axis_x_shift      // 0000 0101  (5)
    val top = (axis_pull_before or axis_specified) shl axis_y_shift     // 0011 0000  (48)
    val bottom = (axis_pull_after or axis_specified) shl axis_y_shift   // 0101 0000  (80)

    // 发现了什么，左移动0位与4位的区别
    val CENTER_VERTICAL = axis_specified shl axis_y_shift               // 0001 0000  (16)
    val FILL_VERTICAL = top or bottom                                   // 0111 0000  (112)
    val CENTER_HORIZONTAL = axis_specified shl axis_x_shift             // 0000 0001  (1)
    val FILL_HORIZONTAL = left or right                                 // 0000 0111  (7)

    val CENTER = CENTER_VERTICAL or CENTER_HORIZONTAL                   // 0001 0001  (17)
    val FILL = FILL_VERTICAL or FILL_HORIZONTAL                         // 0111 0111


    val CLIP_VERTICAL = axis_clip shl axis_y_shift                      // 1000 0000
    val CLIP_HORIZONTAL = axis_clip shl axis_x_shift                    // 0000 1000


    // 水平方向 mask 遮罩
    val HORIZONTAL_GRAVITY_MASK = axis_specified or
            axis_pull_before or axis_pull_after shl axis_x_shift        // 0000 0111
    val VERTICAL_GRAVITY_MASK = axis_specified or
            axis_specified or axis_pull_after shl axis_x_shift          // 0111 0000


    // left 与 start， end 与 right 的兼容性
    val RELATIVE_LAYOUT_DIRECTION = 0x00800000              // 1000 0000 0000 0000 0000 0000
    val START = RELATIVE_LAYOUT_DIRECTION or left           // 1000 0000 0000 0000 0000 0011
    val END = RELATIVE_LAYOUT_DIRECTION or right            // 1000 0000 0000 0000 0000 0101
    val RELATIVE_HORIZONTAL_GRAVITY_MASK = START or END     // 1000 0000 0000 0000 0000 0111


    // 32位
    val DISPLAY_CLIP_VERTICAL = 0x10000000                  // 0001 0000 0000 0000 0000 0000 0000 0000
    val DISPLAY_CLIP_HORIZONTAL = 0x01000000                // 0000 0001 0000 0000 0000 0000 0000 0000

    println(Integer.toBinaryString(DISPLAY_CLIP_HORIZONTAL))



    // println("${axis_pull_before or axis_specified} ---> ${Integer.toBinaryString(axis_pull_before or axis_specified)}")
}