package com.vtiger.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Its developed using Apache POi libraries , which is used to handle Microsoft
 * Excel sheet
 * 
 * @author ajayb
 *
 */
public class ExcelUtility {
	/**
	 * Its used read the data from excel based on below arguments
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable, Throwable {
		FileInputStream fis = new FileInputStream("./TestData/LeadInfoUtility.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * Its used to get the last used row number on specified Sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/LeadInfoUtility.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		wb.close();
		return sheet.getLastRowNum();
	}

	/**
	 * Its used write the data into excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/LeadInfoUtility.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./TestData/LeadInfoUtility.xlsx");
		wb.write(fos);
		wb.close();
	}
}
