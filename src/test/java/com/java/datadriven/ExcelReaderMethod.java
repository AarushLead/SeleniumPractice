package com.java.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderMethod {
	
	String curDir;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelReaderMethod() throws IOException 
	{
	 curDir = System.getProperty("user.dir") + "/excel/excelread.xlsx";
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

	public void getCellData() throws IOException
	{   
		for (int i = 0; i <getRow(); i++)
		{
			for (int j = 0; j < getCol(i); j++)
			{
				String value = sheet.getRow(i).getCell(j).toString();
				System.out.print(value+"  ");
			}
			System.out.println();
		}
		
		
	}
}
