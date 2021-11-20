package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exception.FrameworkException;
import com.exception.InvalidPathForExcelException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.FrameworkConstants;

public final class ExcelUtils {

	/*
	 * Read Excel sheet data from file.
	 * Variable -
	 * 		sheetname : sheet name in Excel file
	 */
	
	private ExcelUtils() {
		
	}

	public static List<Map<String, String>> getTestDetails(String sheetname){
			List<Map<String,String>> list = null;

			try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {

				XSSFWorkbook workbook = new XSSFWorkbook(fs);
				XSSFSheet sheet = workbook.getSheet(sheetname);
				
				int lastrownum = sheet.getLastRowNum();
				int lastcolnum = sheet.getRow(0).getLastCellNum();
				
				Map<String, String> map = null;
				list = new ArrayList<>();
				
				for(int i=1;i<=lastrownum;i++) {
					map = new HashMap<String, String>();
					for(int j=0;j<lastcolnum;j++) {
						
						//This method has error java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell
						//String key = sheet.getRow(0).getCell(j).getStringCellValue();
						//String value = sheet.getRow(i).getCell(j).getStringCellValue();
						
						DataFormatter formatter = new DataFormatter();
						String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
						String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
						map.put(key, value);
					}
					list.add(map);
				}
			} catch (FileNotFoundException e) {
				throw new InvalidPathForExcelException("Excel File you trying to read is not found");
			} catch (IOException e) {
				throw new FrameworkException("Some io exception happened while reading excel file");
			}
			
		return list;
	}
	
	
}
