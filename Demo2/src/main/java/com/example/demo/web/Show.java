package com.example.demo.web;

import com.alibaba.druid.sql.SQLUtils;
import com.example.demo.controller.ProductController;
import com.example.demo.pojo.Product;
import com.example.demo.servcice.ProductService;
import com.example.demo.servcice.ProductServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Show {
    public static void main(String[] args) throws IOException {
        //通过键盘录入scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要选择的功能：1、导入 2、导出");
        int num = sc.nextInt();
        if (num == 1){
            //1.导入
            //1.1读取execl表格中的数据
            System.out.println("请输入您要读取的文件位置，不包含空格");
            String path = sc.next();
            List<Product> productList = read(path);
            System.out.println(productList);
            //1.2将数据写入到数据库中
            ProductService productService = new ProductServiceImpl();
            productService.save(productList);
            System.out.println("数据存到数据库中");
        }else if (num == 2){
            //2、导出
            //2.1读取数据库中的数据
            //2.2将数据写入到execl表中
        }else {
            System.out.println("输入有误，请重新启动");
        }
    }

    private static List<Product> read(String path) throws IOException {
        List<Product> productList = new ArrayList<>();
        //1、获取工作薄
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(path);
        //2、获取工作表
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1 ; i <= lastRowNum ; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null){
                List<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    if (cell != null){
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        list.add(value);
                    }
                }
                if (list.size() > 0) {
                    Product product = new Product(Integer.parseInt(list.get(0)), list.get(1), Double.parseDouble(list.get(2)), Integer.parseInt(list.get(3)));
                    productList.add(product);
                }
            }
        }
        return productList;
    }
}















