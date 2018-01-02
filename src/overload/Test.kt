package overload

/**
 * Created by zhaoyu on 2017/8/10.
 */

open class Base(value: Int) {
    private var age: Int = 0
    open var name: String? = null
        set(value) {
            //此处作用可能不同,比如复写,也需要让父类走一遍流程.执行一些操作.
            println("base run!")
        }

    init {
        age = value
        //此处触发崩溃,对象构造时机为: base.init{}->animal.init{}
        //但base.init{}内调用了 name属性赋值,name属性会调用Animal的set(value)方法
        // ,而此时animal.init{}未进行初始化,此时,整个类,所有字段均不可访问,包括任何的成员常量.一访问就崩溃
        name = "None name"
    }
}

class Animal1(value: Int) : Base(value) {
    //第一种崩溃,为lazy崩溃
    private val sound: String by lazy { "e e!" }
    override var name: String? = null
        set(value) {
            super.name = value
            field = value
            println("child run")
            //此处调用子类方法,并为一个值赋值
            startCry()
        }

    fun startCry() {
        println("$name is crying! $sound")
    }
}


fun main(args: Array<String>) {
    val b: Animal1 = Animal1(10)
    b.name = "dog"
}