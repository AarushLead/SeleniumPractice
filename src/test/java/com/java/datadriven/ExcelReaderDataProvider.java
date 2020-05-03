package com.java.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderDataProvider {
	
	String curDir;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelReaderDataProvider(String fileName) throws IOException 
	{
	 curDir = System.getProperty("user.dir") + "/excel/"+fileName+".xlsx";
	 fis = new FileInputStream(new File(curDir));
	 wb = new XSSFWorkbook(fis);
	 sheet = wb.getSheet("Sheet1");
	}

	public int getRow() throws IOException
	{
		int row = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return row;
	}

	public int getCol(int r) throws IOException
	{
		int col = sheet.getRow(r).getLastCellNum();
		wb.close();
		fis.close();
		return col;
	}

	public String getCellData(int r,int c) throws IOException
	{   
		String value = sheet.getRow(r).getCell(c).toString();
		return value;
	}
}