package myjsonTools

import com.better.json.data.County
import com.better.json.serialize
import org.junit.Test

data class Person(val name: String, val age: Int) {
    val map = HashMap<String, Map<String, County>>()
    val set = mutableSetOf<County>()
    init {
        val county1 = County("湘潭", 20)
        val county2 = County("长沙", 100)
        val map1 = mapOf("JavaEE" to county1, "JavaSE" to county2)

        map["Java"] = map1
        map["Kotlin"] = map1

        set += county1
        set += county2
    }
}

class MyJsonToolsTest {
    @Test
    fun testMapToJson() {
        val person = Person("Alice", 29)
        val result = serialize(person)
        println(result)
    }
}

