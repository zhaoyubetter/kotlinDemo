
import com.better.json.deserialize.JsonObject
import com.better.json.deserialize.MalformedJSONException
import com.better.json.deserialize.Parser
import org.junit.Test
import java.io.StringReader
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ParserTest {
    @Test fun testTrivial() {
        verifyParse("""{"s": "x"}""", JsonParserAction.VisitValue(0, "s", "x"))
    }

    @Test fun testTwoProperties() {
        verifyParse("""{"s": "x", "f": 1}""",
                JsonParserAction.VisitValue(0, "s", "x"),
                JsonParserAction.VisitValue(0, "f", 1L))
    }

    @Test fun testMissingComma() {
        verifyMalformed("""{"s": "x" "f": 1}""")
    }

    @Test fun testNestedObject() {
        verifyParse("""{"s": {"x": 1}}""",
                JsonParserAction.CreateObject(1, "s"),
                JsonParserAction.VisitValue(1, "x", 1L))
    }

    @Test fun testArray() {
        verifyParse("""{"s": [1, 2]}""",
                JsonParserAction.CreateArray(1, "s"),
                JsonParserAction.VisitValue(1, "s", 1L),
                JsonParserAction.VisitValue(1, "s", 2L))
    }

    @Test fun testArrayOfObjects() {
        verifyParse("""{"s": [{"x": 1}, {"x": 2}]}""",
                JsonParserAction.CreateArray(1, "s"),
                JsonParserAction.CreateObject(2, "s"),
                JsonParserAction.VisitValue(2, "x", 1L),
                JsonParserAction.CreateObject(3, "s"),
                JsonParserAction.VisitValue(3, "x", 2L))
    }

    private fun verifyParse(json: String, vararg expectedCallbackCalls: JsonParserAction) {
        val reportingObject = ReportingJsonObject(0)
        Parser(StringReader(json), reportingObject).parse()
        assertEquals(expectedCallbackCalls.size, reportingObject.actions.size)
        for ((expected, actual) in expectedCallbackCalls zip reportingObject.actions) {
            assertEquals(expected, actual)
        }
    }

    private fun verifyMalformed(text: String) {
        assertFailsWith<MalformedJSONException> {
            Parser(StringReader(text), ReportingJsonObject(0)).parse()
        }
    }

    interface JsonParserAction {
        data class CreateObject(val objId: Int, val propertyName: String) : JsonParserAction
        data class CreateArray(val objId: Int, val propertyName: String) : JsonParserAction
        data class VisitValue(val objId: Int, val propertyName: String, val value: Any?) : JsonParserAction
    }

    class ReportingData(var maxId: Int, val actions: MutableList<JsonParserAction> = mutableListOf())

    class ReportingJsonObject(
            val id: Int,
            private val reportingData: ReportingData = ReportingData(0, mutableListOf())
    ) : JsonObject {
        val actions: List<JsonParserAction>
            get() = reportingData.actions

        override fun setSimpleProperty(propertyName: String, value: Any?) {
            reportingData.actions.add(JsonParserAction.VisitValue(id, propertyName, value))
        }

        override fun createObject(propertyName: String) = createCompositeProperty(propertyName, false)

        override fun createArray(propertyName: String) = createCompositeProperty(propertyName, true)

        private fun createCompositeProperty(propertyName: String, isCollection: Boolean): JsonObject {
            reportingData.maxId++
            val newId = reportingData.maxId
            reportingData.actions.add(if (isCollection) JsonParserAction.CreateArray(newId, propertyName) else JsonParserAction.CreateObject(newId, propertyName))
            return ReportingJsonObject(newId, reportingData)
        }
    }
}