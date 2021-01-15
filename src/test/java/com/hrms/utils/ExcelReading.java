package com.hrms.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReading {
    public static Workbook book;
    public static Sheet sheet;

    /**
     * this method will read data from excel file
     *
     * @param filePath
     */
    public static void openExcel(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            book = new XSSFWorkbook(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * this method will get a specific  sheet
     *
     * @param sheetName
     */
    public static void getSheet(String sheetName) {

        sheet = book.getSheet(sheetName);
    }

    /**
     * This method will return us number of rows
     *
     * @return
     */
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();

    }

    /**
     * This method will return us number of Columns
     *
     * @param rowIndex
     * @return
     */
    public static int getColsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();

    }

    public static String getCellData(int rowIndex,int colIndex ){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }


    public static  List<Map<String, String>> exelIntoListOfMaps(String filePath, String sheetName) {
        openExcel(filePath);
        getSheet(sheetName);
        //creating list of maps
        List<Map<String, String>> listData = new ArrayList();

        //looping through rows
        for (int row = 1; row < getRowCount(); row++) {
            //creating a Map for each row
            Map<String, String> map=new LinkedHashMap<>();
            //looping through all cells in specific row
            for (int col = 0; col < getColsCount(row); col++) {
                map.put(getCellData(0,col),getCellData(row,col));
            }
            listData.add(map);
        }

        return listData;
    }



}
