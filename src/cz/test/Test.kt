package cz.test
/*
import com.google.gson.JsonParser
import cz.model.plugin.json.JsonFormatter

/**
 * Created by zhaoyu on 2017/6/4.
 */
fun main(args: Array<String>) {
    // println(isJson("[]"))
//    testJsonFormat();

    var list = arrayListOf<Int>(2, 9, 0, 3, 1, 5)
    var temp = (0..list.size - 1).map { it }
//    println(temp)

    //list.mapIndexed { index, i -> println("${index} .... ${i}") }

    println(list.slice(listOf(0,2)))
}

fun testJsonFormat() {
    val json: String = """
{
    "rating": {
        "max": 10,
        "numRaters": 363,"average": "7.1","min": 0
    },
    "subtitle": "",
    "author": [
        "[日] 片山恭一"
    ],
    "pubdate": "2005-1",
    "tags": [
        {
            "count": 143,
            "name": "片山恭一",
            "title": "片山恭一"
        },
        {
            "count": 69,
            "name": "日本",
            "title": "日本"
            "config":[]
        },
        {
            "count": 65,
            "name": "日本文学",
            "title": "日本文学"
            "config":{app="aaa"}
        },
        {
            "count": 41,
            "name": "小说",
            "title": "小说"
        },
        {
            "count": 33,
            "name": "满月之夜白鲸现",
            "title": "满月之夜白鲸现"
        },
        {
            "count": 16,
            "name": "爱情",
            "title": "爱情"
        },
        {
            "count": 10,
            "name": "純愛",
            "title": "純愛"
        },
        {
            "count": 9,
            "name": "外国文学",
            "title": "外国文学"
        }
    ],
    "origin_title": "",
    "image": "https://img3.doubanio.com/mpic/s1747553.jpg",
    "binding": "平装",
    "translator": [
        "豫人"
    ],
    "catalog": "\n      ",
    "pages": "180",
    "images": {
        "small": "https://img3.doubanio.com/spic/s1747553.jpg",
        "large": "https://img3.doubanio.com/lpic/s1747553.jpg",
        "medium": "https://img3.doubanio.com/mpic/s1747553.jpg"
    },
    "alt": "https://book.douban.com/subject/1220562/",
    "id": "1220562",
    "publisher": "青岛出版社",
    "isbn10": "7543632608",
    "isbn13": "9787543632608",
    "title": "满月之夜白鲸现",
    "url": "https://api.douban.com/v2/book/1220562",
    "alt_title": "",
    "author_intro": "",
    "summary": "那一年，是听莫扎特、钓鲈鱼和家庭破裂的一年。说到家庭破裂，母亲怪自己当初没有找到好男人，父亲则认为当时是被狐狸精迷住了眼，失常的是母亲，但出问题的是父亲……。",
    "price": "15.00元"
}
    """

    val jsonFormat = JsonFormatter("A.java", json, true)
    println(jsonFormat.format())
}

fun isJson(value: String?): Boolean {
    var result = false
    try {
        val jsonElement = JsonParser().parse(value)
        result = (jsonElement.isJsonArray || jsonElement.isJsonObject)
    } catch (e: Exception) {
        result = false
    }
    return result
}
        */