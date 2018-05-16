package cz.sample.kotlin.companion_

class User {
    val nickName: String

    constructor(email: String) {
        nickName = email.substringBefore("@")
    }

    constructor(accountId: Int) {
        nickName = accountId.toString()
    }
}

// 使用伴生对象 (工厂方法) 创建不同的类实例
data class User2 private constructor(val nickname: String) {

    // 伴生还可以实现接口
    companion object : Comparator<User2> {
        override fun compare(o1: User2, o2: User2): Int {
            return o1.nickname.compareTo(o2.nickname)
        }

        // 根据用途来命名工厂方法
        fun newEmailUser(email: String) = User2(email.substringBefore("@"))

        fun newAccountUser(accountId: Int) = User2(accountId.toString())
    }
}

fun main(args: Array<String>) {
    val user = User("zhaoyubetter@126.com")


    // companion，更加直观
    val user2 = User2.newEmailUser("zhaoyubetter@gmail.com")
    println(user2.nickname)

    // 比较接口
    val persons = listOf(User2.newEmailUser("better@gmail.com"),
            User2.newEmailUser("Chelsea@gmail.com"), User2.newAccountUser(3355))
    println(persons.sortedWith(User2.Companion))
}
