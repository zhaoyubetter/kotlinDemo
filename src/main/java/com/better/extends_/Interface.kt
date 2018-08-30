package com.better.extends_

interface I {

}

fun I.addView() {
    println("add View")
}

class O : I {

}

fun main(args: Array<String>) {
    val i:O = O()
    i.addView()
}