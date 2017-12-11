package io

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.File


/**
 * Created by zhaoyu1 on 2017/7/21.
 */
object ExcelOperator {
    fun createExcel(fileName: String, data: List<RowData>) {
        val wb = XSSFWorkbook()
        val sheet = wb.createSheet("sheet1")
        (0..data.size - 1).forEach {
            val row = sheet.createRow(it)
            row.createCell(0).setCellValue(data[it].key)
            row.createCell(1).setCellValue(data[it].value)
        }

        val fos = FileOutputStream(fileName)
        wb.write(fos)
        fos.flush()
        fos.close()
    }
}
