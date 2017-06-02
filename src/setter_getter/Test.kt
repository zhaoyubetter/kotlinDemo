package setter_getter

/**
 * setter getter 测试
 * Created by zhaoyu1 on 2017/6/2.
 */
class LengthCounter {
    var counter: Int = 0
        private set     // 私有 set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCouter = LengthCounter()
    lengthCouter.addWord("better")
    println(lengthCouter.counter)

    println("=================  equals ========================")
    val client1 = Client("better", 556677)
    val client2 = Client("better", 556677)
    println(client1)
    println("equals:${client1 == client2}")        // == 类似 java中的equals

    println("=================  hashCode ========================")
    val set = setOf(Client("Alice", 112233))
    println(set.contains(Client("Alice", 112233)))


    println("=================  可自动生成 toString(), equals() hashCode() ========================")
    /**
     * 在类定义前加入 data 修饰符
     * @link MyClient
     */
    val myClient1 = MyClient("better", 234)
    val myClient2 = MyClient("better", 234)
    val mySet = setOf(myClient1)
    println(mySet.contains(myClient2))          // 不加 data， 打印 false
    println(myClient1)
}

////////////////////////////////////////////////////////////////////////
class Client(val name: String, val postCode: Int) {
    // override toString()
    override fun toString(): String = "Client(name=$name, postCode=$postCode)"

    override fun equals(other: Any?): Boolean {         // Any 类似 java中的Object，Any?表示 other变量可为null
        if (other == null || other !is Client) {     // is 类似 java 中 instanceOf
            return false
        }
        return name == other.name && postCode == other.postCode;
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postCode

}

// 加入data
data class MyClient(val name: String, val postCode: Int)