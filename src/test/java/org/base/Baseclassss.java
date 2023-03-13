package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclassss {
	
public static WebDriver driver;
	
	public static void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void windowMaximize() {
    driver.manage().window().maximize();
	}
	
	public static void launchUrl(String Url) {
		driver.get(Url);
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public static void pageUrl() {
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
	}
	
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
		
	}
	
	public static void closeEntirebrowser() {
		driver.quit();

	}
	
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	
	public static void Screenshot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
        File f = new File("location+ imgName.png");
        FileUtils.copyFile(image, f);
        
	}
	
	public static Actions a;
	
	public static void MovetheCursor(WebElement targetwebelement) {
		a = new Actions(driver);
		a.moveToElement(targetwebelement).perform();
	}
	
	public static void  DragDrop(WebElement dragWebElement, WebElement dropElement) {
	a = new Actions(driver);
	a.dragAndDrop(dragWebElement, dropElement).perform();
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollThePage(WebElement element) {
		js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(false)", element);
	    
	}
	
	public static void  excelRead(String sheetName, int rowNum, int cellNum) throws IOException
	{
		File f = new File("excellocation.xlsi");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("Data");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int celltype = c.getCellType();
	
		String Value = " ";
		if (celltype == 1) {
			String value2 = c.getStringCellValue();
			
		}
		else if (DateUtil.isCellInternalDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(Value);
			String value1 = s.format(dd);
			
		}
		else {
			double d = c.getNumericCellValue();
		long l = (long) d;
		String ValueOf = String.valueOf(1);
		
		}
	}
		public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("Excel location.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newsheet = w.createSheet("Datas");
		Row newRow = newsheet.createRow(rowNum);
		Cell newcell = newRow.createCell(cellNum);
		newcell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
		
		
         public static void createcell(int getRow, int creCell, String newData) throws IOException {
        	 File f = new File("Excel location.xlsx");
        	 FileInputStream fis = new FileInputStream(f);
        	 Workbook wb = new XSSFWorkbook(fis);
        	 Sheet s = wb.getSheet("Datas");
        	 Row r = s.getRow(creCell);
        	 Cell c = r.createCell(creCell);
        	 c.setCellValue(newData);
        	 FileOutputStream fos = new FileOutputStream(f);
        	 wb.write(fos);
         }
         
         public static void createRow(int creRow, int creCell, String newData) throws IOException
         {
        	 File f = new File("Excel file.xlsx");
        	 FileInputStream fis = new FileInputStream(f);
        	 Workbook wb = new XSSFWorkbook(fis);
        	 Sheet s = wb.getSheet("Datas");
        	 Row r = s.getRow(creCell);
        	 Cell c = r.createCell(creCell);
        	 c.setCellValue(newData);
        	 FileOutputStream fos = new FileOutputStream(f);
        	 wb.write(fos);
         }
         
         public static void updateDataToParticularCell(int getTheRow, int getThecell, String existingData, String writeNewData) throws IOException {
        	 File f = new File("Excel file.xlsx");
        	 FileInputStream fis = new FileInputStream(f);
        	 Workbook wb = new XSSFWorkbook(fis);
        	 Sheet s = wb.getSheet("Datas");
        	 Row r = s.getRow(getTheRow);
        	 Cell c = r.createCell(getThecell);
             String str = c.getStringCellValue();
            if (str.equals(existingData)) {
				c.setCellValue(writeNewData);
			}
            FileOutputStream fos = new FileOutputStream(f);
       	    wb.write(fos);         
         }    
         


}
