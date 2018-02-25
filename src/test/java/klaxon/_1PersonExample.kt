
package klaxon

import com.better.json.data.County
import com.better.json.serialize
import com.beust.klaxon.Klaxon
import com.google.gson.Gson
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

        (0..100000).forEach {
            map[""+it] = map1
        }

        set += county1
        set += county2
    }
}

class PersonTest {
    @Test fun testMapToJson() {
        val person = Person("Alice", 29)
        val startTime = System.currentTimeMillis()
        val result = Klaxon().toJsonString(person)      // DefaultConverter
        println(result)
        println("cost ${(System.currentTimeMillis() - startTime) * 1.0f / 1000 }s")

    }

    @Test fun testMapUseGson() {
        val person = Person("Alice", 29)
        val startTime = System.currentTimeMillis()
        val result = Gson().toJson(person)      // DefaultConverter
        println(result)
        // gson 最快
        println("cost ${(System.currentTimeMillis() - startTime) * 1.0f / 1000 }s")
    }
}