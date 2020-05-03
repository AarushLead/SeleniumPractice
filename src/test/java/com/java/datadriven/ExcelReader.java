package com.java.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		String curDir=System.getProperty("user.dir")+"/excel/excelread.xlsx";
		FileInputStream fis=new FileInputStream(new File(curDir));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");  //Get the Current sheet
		int totalRow = sheet.getLastRowNum();   //Get the Total rows
		for (int i = 0; i < totalRow; i++) {
			XSSFRow curRow = sheet.getRow(i);  //Get the current row
			short totalCol = curRow.getLastCellNum();  //get the total column in each row
			for (int j = 0; j < totalCol; j++) {
			String value=sheet.getRow(i).getCell(j).toString();  //Get the value of each cell
			System.out.print(value+" "); 
			}
			System.out.println();
		}

	}

}
