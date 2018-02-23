
package klaxon

import com.better.json.data.County
import com.beust.klaxon.Klaxon
import com.google.gson.Gson
import org.junit.Test

data class Person(val name: String, val age: Int) {
    val map = HashMap<County, Int>()
    init {
        val county1 = County("湘潭", 20)
        val county2 = County("长沙", 100)
        map[county1] = 567
        map[county2] = 999
    }
}

class PersonTest {
    @Test fun testMapToJson() {
        val person = Person("Alice", 29)
        val result = Klaxon().toJsonString(person)      // DefaultConverter
        println(result)
    }

    @Test fun testMapUseGson() {
        val person = Person("Alice", 29)
        val result = Gson().toJson(person)      // DefaultConverter
        println(result)
    }
}