package Basecls;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.text.SimpleDateFormat;

public class Baseclass {
	// Declare WebDriver at class level to be shared by all methods
	public static WebDriver driver;
	public static Actions a;
	public static JavascriptExecutor js;

	// Method to launch browser
	public static void launchBrowser() {
		driver = new ChromeDriver(); // Fix: Use class-level 'driver' instead of local variable
	}

	// Method to maximize the browser window
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	// Method to open URL
	public static void launchUrl(String url) {
		driver.get(url);
	}

	// Method to get page title
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	// Method to get current URL
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	// Method to send text to an element
	public static void passText(String txt, WebElement els) {
		els.sendKeys(txt);
		els.clear();
	}

	// Method to click a button
	public static void clickBtn(WebElement els) {
		els.click();
	}

	// Method to close browser
	public static void closeBrowser() {
		driver.quit(); // Use quit() to close all windows and terminate the WebDriver session
	}

	// Method to take a screenshot
	public static void screenshot(String imgname) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File image = t.getScreenshotAs(OutputType.FILE);
		File f = new File("screenshots/" + imgname + ".png"); // Fix path to "screenshots/" folder
		FileUtils.copyFile(image, f);
	}

	// Method to move the cursor to a specific element
	public static void moveCursor(WebElement targetWeb) {
		a = new Actions(driver);
		a.moveToElement(targetWeb).perform();
	}

	// Method to drag and drop an element
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
	}

	// Method to scroll the page to a specific element
	public static void scrollThePage(WebElement targetElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
	}

	// Method to scroll the page away from a specific element
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	// Method to read data from an Excel file
	public static String readExcel(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("Excel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = "";

		// Process string cells
		if (cell.getCellType() == CellType.STRING) {
			value = cell.getStringCellValue();
		}
		// Process numeric cells
		else if (cell.getCellType() == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				value = sdf.format(cell.getDateCellValue());
			} else {
				value = String.valueOf(cell.getNumericCellValue());
			}
		}
		wb.close(); // Close the workbook after reading
		return value;
	}

	// Method to create a new Excel file and write data
	public static void createNewExcel(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("create.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Data-details");
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close(); // Close the workbook after writing
		fos.close();
	}

	// Method to create a cell in an existing Excel file and write data
	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("create.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Datas");
		Row row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum); // Create row if it doesn't exist
		}
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		fos.close();
	}

	// Method to create a row in an existing Excel file and write data
	public static void createRow(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("create.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Datas");
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		fos.close();
	}

	// Method to update data in a specific cell
	public static void updateDataToParticularCell(int rowNum, int cellNum, String existingData, String newData)
			throws IOException {
		File f = new File("create.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Datas");
		Row row = sheet.getRow(rowNum);
		if (row != null) {
			Cell cell = row.getCell(cellNum);
			if (cell != null && cell.getStringCellValue().equals(existingData)) {
				cell.setCellValue(newData);
			}
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		fos.close();
	}
}
