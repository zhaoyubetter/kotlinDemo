package constructor_

/**
 * Created by zhaoyu1 on 2017/6/2.
 */

//主构造器
class User(val nickName: String)

class User2 constructor(_nickName: String) {
    val nickName: String

    // 初始化代码块
    init {
        nickName = _nickName
    }
}

class User3(_nickName: String) {
    val nickName: String = _nickName
}

// 次要构造
open class View {
    constructor(ctx: String) {
    }

    constructor(ctx: String, other: Int) {
    }
}

// 调用父类构造
class MyButton : View {
    constructor(ctx: String) : super(ctx)

    constructor(ctx: String, other: Int) : super(ctx, other)
}


///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
interface MyUser {
    val nickName: String    // 接口中，可声明变量
}

class PrivateUser(override val nickName: String) : MyUser

class SubscribingUser(val email:String): MyUser {
    override val nickName: String
        get() = email.substringBefore("@")      // 自定义getter属性初始化器
}

fun main(args: Array<String>) {
    println(PrivateUser("zhaoyubetter@gmail.com").nickName)
    println(SubscribingUser("zhaoyubetter@gmail.com").nickName)
}
