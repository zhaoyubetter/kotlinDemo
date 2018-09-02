package com.test.operator

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("\n======== reduce ========================")
    println(list.reduce { init, it -> init + it })

    println("\n======== reduceRight ========================")
    // right to left
    val i = list.reduceRight { index, it ->
        print("index:$index,value:$it ")
        index + it
    }

}
