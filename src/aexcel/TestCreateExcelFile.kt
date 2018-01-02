package aexcel

import jxl.Workbook
import jxl.format.*
import jxl.write.Label
import java.io.File
import jxl.write.WritableCellFormat
import jxl.write.WritableFont
import jxl.write.WriteException


/**
 * Created by zhaoyu on 2017/8/5.
 */

fun main(args: Array<String>) {

    val excelFile = File("test.xls")
    // 1、创建工作簿(WritableWorkbook)对象
    val writeBook = Workbook.createWorkbook(excelFile)
    val sheet = writeBook.createSheet("test", 0)

    val cell_1 = Label(0, 0, "Hello,World")

    val TableFormat = WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE)
    val tableFormatBackground = WritableCellFormat() //table cell format
    tableFormatBackground.setBackground(Colour.DARK_BLUE) //Table background
    tableFormatBackground.setFont(TableFormat) //set the font
    cell_1.cellFormat = tableFormatBackground

    sheet.addCell(cell_1)

    // --- 写入文件
    writeBook.write()
    writeBook.close()

}

@Throws(WriteException::class)
fun createFormatCellStatus(b: Boolean): WritableCellFormat {
    val colour = if (b) Colour.GREEN else Colour.RED
    val wfontStatus = WritableFont(WritableFont.createFont("Arial"),
            WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, colour)
    val fCellstatus = WritableCellFormat(wfontStatus)

    fCellstatus.wrap = true
    fCellstatus.alignment = jxl.format.Alignment.CENTRE
    fCellstatus.verticalAlignment = jxl.format.VerticalAlignment.CENTRE
    fCellstatus.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM, jxl.format.Colour.BLUE2)
    return fCellstatus
}

class TestCreateExcelFile {

}