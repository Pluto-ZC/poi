package wzc.write;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //1、创建工作薄对象
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2、创建工作表
        XSSFSheet sheet = workbook.createSheet("工作表一");
        //3、创建行
        XSSFRow row1 = sheet.createRow(0);
        //创建单元格
        row1.createCell(0).setCellValue("WZC1");
        row1.createCell(1).setCellValue("WZC2");
        row1.createCell(2).setCellValue("WZC3");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("WZC1");
        row2.createCell(1).setCellValue("WZC2");
        row2.createCell(2).setCellValue("WZC3");

        //输出流
        FileOutputStream out = new FileOutputStream("C:\\Users\\17848\\Desktop\\bbb.xlsx");
        workbook.write(out);
        out.flush();
        //释放资源
        out.close();
        workbook.close();
    }
}
