package by_

val test: String = "better"

fun test() {
    println("test")
}

/**
 * by 委托
 * Created by zhaoyu1 on 2017/6/2.
 */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {

    // 1.委托MutableCollection的实现给innerSet
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 3, 3))
    println("${cset.objectsAdded} objects were added. ${cset.size} remain")

    println("=============================")
    val impl:LoginImpl = LoginImpl()
    CountLogin(impl).doLogin()
    println()
}

interface Login {
    fun doLogin()
}

class LoginImpl : Login {
    override fun doLogin() {
        println("执行了doLogin方法...")
    }
}

class CountLogin(val login: LoginImpl) : Login by login {
    var count = 0
    override fun doLogin() {
        count++
        login.doLogin()
        println("次数： ${count}")
    }
}