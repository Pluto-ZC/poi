
package wzc.read;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //1、获取工作薄 - 当前的execl
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\17848\\Desktop\\aaa.xlsx");
        //2、获取工作表 - execl中的sheet
            //getSheetAt（索引）  索引 从零开始
            //getSheet(sheet名)
        XSSFSheet sheet = workbook.getSheetAt(0);
        //3、获取行
       /* for (Row row : sheet) {
            //获取单元格
            for (Cell cell : row) {
                //获取单元格中的内容
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }*/
        //开始索引 0 结束索引
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum ; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row!=null){
                short cellNum = row.getLastCellNum();
                for (int j = 0; j <= cellNum; j++) {
                    XSSFCell cell = row.getCell(j);
                    if (cell!=null){
                        System.out.println(cell.getStringCellValue());
                    }

                }
            }

        }

        //4、释放资源
        workbook.close();
    }
}
