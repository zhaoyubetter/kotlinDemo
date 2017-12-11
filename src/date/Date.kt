package date

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by zhaoyu1 on 2017/7/27.
 */
fun main(args: Array<String>) {

    val dateStr = 1501127864613
    val date = "2017-07-27 04:20:10"

    val dateFMTStr = "yyyy-MM-dd HH:mm:ss"
    val locale = Locale.getDefault()

    val simpleDateFmt = SimpleDateFormat(dateFMTStr)
    simpleDateFmt.timeZone = TimeZone.getTimeZone("GMT")        // 标准时间 -8

    // 当前
    val time = Calendar.getInstance().timeInMillis
    println("当前世界：$time")
    println(simpleDateFmt.format(time))

    println("时间格式：${SimpleDateFormat("ahh:mm").format(Date())}")
    println("日期格式：${SimpleDateFormat("dd/MM/yyyy").format(Date())}")


    Locale.setDefault(Locale.CANADA)
    println("日期时间：${SimpleDateFormat("d MMM yyyy hh:mm a").format(Date())}")
    println("时间格式：${SimpleDateFormat("hh:mm a").format(Date())}")


    println("=====================================")
    println(SimpleDateFormat("d MMM yyyy hh:mm a").parse("28 Jul 2017 10:08 AM").time)

}