package com.example.demo.controller;

import com.example.demo.pojo.Product;
import com.example.demo.servcice.ProductService;
import com.example.demo.servcice.ProductServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("/import")
    @ResponseBody
    public String save() throws IOException {
        String path = "C:\\Users\\17848\\Desktop\\aaa.xlsx";
        List<Product> productList = read(path);
        productService.save(productList);
        return "导入成功";
    }
    @RequestMapping("/export")
    @ResponseBody
    public String export() throws IOException {
        List<Product> productList = productService.findAll();
        write(productList,"C:\\Users\\17848\\Desktop\\bbb.xlsx");
        return "导出成功";
    }

    private void write(List<Product> productList, String s) throws IOException {
        //1、创建一个工作薄
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //2、创建一个工作表
        XSSFSheet sheet = xssfWorkbook.createSheet("商品");
        //3、创建行
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("pid");
        row.createCell(1).setCellValue("name");
        row.createCell(2).setCellValue("price");
        row.createCell(3).setCellValue("pstock");
        for (int i = 0; i < productList.size(); i++) {
            XSSFRow row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(productList.get(i).getPid());
            row1.createCell(1).setCellValue(productList.get(i).getName());
            row1.createCell(2).setCellValue(productList.get(i).getPrice());
            row1.createCell(3).setCellValue(productList.get(i).getPstock());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(s);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();

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
