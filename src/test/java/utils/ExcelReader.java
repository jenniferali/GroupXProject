package utils;

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

public class ExcelReader {

    static Workbook book;
    static Sheet sheet;


    public static void openExcel(String filePath){
        // OPENING the Excel file
        try {
            FileInputStream fis = new FileInputStream(filePath);
            book = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            // To get exception if file is not available
            e.printStackTrace();
        } catch (IOException e) {
            // To get exception if input or output is not up to the mark
            e.printStackTrace();
        }
    }

    public static void getSheet(String sheetName){
        // This will identify the sheet we are going to read from Excel file
        sheet = book.getSheet(sheetName);
    }

    public static int getRowCount(){
        // This will return total rows that have data
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowIndex){
        // This will return total number of columns from every row
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }
        // This method will return the data
    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

    public static List<Map<String,String >> excelListIntoMap
            (String filePath, String sheetName){

        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String, String>> listData = new ArrayList<>();

        //outer loop
        // it takes care of total rows in Excel file
        //because row 0 has all keys, start with row =1
        //this for loop will read the values from all the rows (VALUES)
        for (int row = 1; row < getRowCount(); row++ ){

            //create a map for every row, for every key-value pair
            //for data searching,sorting use LinkedHashMap
            //inner for-loop
            Map<String, String> map = new LinkedHashMap<>();

            //looping through all the values of the cells (KEYS)
            for ( int col = 0; col < getColsCount(row); col++){
                //(rowIndex:0,col) reads all the KEYS only
                // (get CellData(row, col) will read all the VALUES only
                map.put(getCellData(0,col), getCellData(row, col));
            }
            listData.add(map);

        }

        return listData;
    }
}









