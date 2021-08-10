package utilityLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRader {

	
	String testFile = "";

	public HashMap<String, String> readTestData(String sheetName, int rowIndex) {

		HashMap<String, String> personInfo = new HashMap<>();
		try {
			File f = new File(testFile);
			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook book = new XSSFWorkbook(fis);

			XSSFSheet userInfo = book.getSheet(sheetName); //"userName"

			XSSFRow firstRow = userInfo.getRow(0);
			int index = 0;
			for (Cell cell : firstRow) {
				String value = userInfo.getRow(rowIndex).getCell(index).getStringCellValue();

				personInfo.put(cell.getStringCellValue(), value);
				index++;
			}

			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personInfo;
	}
	

	public HashMap<String, String> readTestData(String sheetName, String key) {

		HashMap<String, String> dataMap = new HashMap<>();
		try {
			File f = new File(testFile);
			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook book = new XSSFWorkbook(fis);

			XSSFSheet Sheet = book.getSheet(sheetName);
			
			int rowIndex=-1;
			for (int i = 0; i <= Sheet.getLastRowNum(); i++) {

				String currentkey = Sheet.getRow(i).getCell(0).getStringCellValue();
				if(currentkey.equalsIgnoreCase(key)) {
					rowIndex = i;
					break;
				}
			}

			int index = 0;
			for (Cell cell : Sheet.getRow(0)) {
				String value = Sheet.getRow(rowIndex).getCell(index).getStringCellValue();

				dataMap.put(cell.getStringCellValue(), value);
				index++;
			}

			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataMap;
	}

	
}
