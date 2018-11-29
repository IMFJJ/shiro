package com.study.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONObject;



/**
 *
 * Title: excelTest
 * Description: excel表格读取
 * 注意:引用poi 架包版本要一致
 * 如:
 * poi-3.13.jar
 * poi-ooxml-3.13.jar
 * poi-ooxml-schemas-3.13.jar
 * poi-scratchpad-3.13.jar
 * 这些架包版本随意
 * stax-api.jar
 * xmlbeans.jar
 * dom4j.jar
 * Version:1.0.0
 * @author pancm
 */
public class ExcelUnit {

    private static final String path1="D:\\file\\test1.xlsx";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<JSONObject> list=new ArrayList<>();
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("dTime","2018");
        jsonObject.put("name","有爱");
        list.add(jsonObject);
        writeXlsx(list);
    }

    //写入Xlsx
    public static void writeXlsx(List list) {
        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("test");
            XSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("公司名称");
            row.createCell(1).setCellValue("时间");
            for(int i=1;i<=list.size();i++){
                //因为第一行已经设置了，所以从第二行开始
                XSSFRow row1  = sheet.createRow(i);
                JSONObject json=(JSONObject) list.get(i-1);
                row1.createCell(0).setCellValue(json.getString("name"));
                row1.createCell(1).setCellValue(json.getString("dtime"));
            }
            FileOutputStream outputStream = new FileOutputStream(path1);
            wb.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}