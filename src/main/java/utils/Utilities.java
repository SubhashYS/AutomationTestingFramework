package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Utilities{
	WebDriver driver;

	public Utilities(WebDriver driver) {
		this.driver = driver;
	}
	
	//method to take screenshot
	public static String takeScreenshot(WebDriver driver, String screenshotName){	
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String  dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	
	public void readDataFromExcel() throws Throwable {
		
		String path = System.getProperty("user.dir")+"\\testData\\testData.xlsx";
		
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Login");
			
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			
			for(int i=0; i<rowCount; i++) {//this is for row
				XSSFRow row = sheet.getRow(i+1);
				for(int j=0; j<colCount; j++) { //this is for column
					XSSFCell cell = row.getCell(j);
					
					switch(cell.getCellType()) {
					
					case STRING:	System.out.print(cell.getStringCellValue()+" | ");
									
									break;
					case NUMERIC:	System.out.print(cell.getNumericCellValue()+" | ");
									
									break;
					}
				}
				System.out.println();
			}	
	}
}
















