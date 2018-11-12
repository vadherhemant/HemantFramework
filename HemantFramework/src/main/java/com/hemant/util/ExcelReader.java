package com.hemant.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {

		ExcelReader er = new ExcelReader();

		er.readExcel("resources/excel", "LoginCredentials.xlsx", "Sheet1");

	}

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			workbook = new XSSFWorkbook(inputStream);

		}

		else if (fileExtensionName.equals(".xls")) {

			workbook = new HSSFWorkbook(inputStream);

		}

		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		int i;
		int j;

		for (i = 0; i < rowCount + 1; i++) {

			Row row = sheet.getRow(i);

			for (j = 0; j < row.getLastCellNum(); j++) {

				GenericUtil.logConsoleMessage(row.getCell(j).getStringCellValue().toString() + "|| ");

			}

			GenericUtil.logConsoleMessage("");

		}
	}
}
