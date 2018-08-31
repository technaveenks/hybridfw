package com.selenium.hybridfw.utils;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtility {
	

		private static XSSFSheet ExcelWSheet;

		private static XSSFWorkbook ExcelWBook;

		private static XSSFCell Cell;

		private static XSSFRow Row;


	public static void setExcelFile() throws Exception {

			try {
				
				//Step 1 - Accessing file

			FileInputStream ExcelFile = new FileInputStream("C://Users//Hp//Appium_Demo//hybridfw//TestData.xlsx");

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet("TestData");
			System.out.println("===="+ ExcelWSheet);

			} catch (Exception e){

				throw (e);

			}

	}

    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	
			try{

  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

  			String CellData = Cell.getStringCellValue();

  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }


	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

			try{

  			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}


  				FileOutputStream fileOut = new FileOutputStream("C://Users//Hp//Appium_Demo//hybridfw//TestData.xslx");

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}

}

