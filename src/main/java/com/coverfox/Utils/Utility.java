package com.coverfox.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static void waitImplicitly(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		System.out.println("Wating for webpage for: " + waitTime + "ms");
	}

	public static void waitExplicitly(WebDriver driver, int waitExplicitly, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(waitExplicitly));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		System.out.println("Wating for Element for: " + waitExplicitly);
	}

	public static void getScreenshot(WebDriver driver, String ScreenshotName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String TimeStamp = new SimpleDateFormat("dd-MM-yyy_HH-mm-ss").format(new Date());
		String path = System.getProperty("user.dir");
		File dest = new File(path + "\\Screenshot\\" + ScreenshotName + "_" + TimeStamp + ".png");
		// File(System.getProperty("user.dir")+"\\Screenshot\\"+ScreenshotName+"_"+TimeStamp+".png");
		System.out.println("Taking Screenshot and saving on Location: " + dest);
		FileHandler.copy(src, dest);
	}

	public static void scrollIntoView(WebDriver driver, WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
		System.out.println("Scroll Into View: " + webElement.getText());

	}

	public static String readDataFromExcel(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream myfile = new FileInputStream("D:\\Nilam\\JavaPractice_Updated\\coverfox\\src\\main\\resources\\TestData");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet(sheetName);
		String mydata = mySheet.getRow(row).getCell(cell).getStringCellValue();
		System.out.println("mydata is: " + mydata);
		return mydata;

	}
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties properties =new Properties();

		FileInputStream myFile=new FileInputStream("D:\\clone_Nilam\\CoverFoxProjectMock07\\src\\main\\resources\\config\\config.properties");
		properties.load(myFile);
		String value=properties.getProperty(key);
		System.out.println("Success");
		System.out.println("Key value is: "+value);
		return value;
		
	}
	public static void  handleDropDownUsingVisibleText(WebElement element,String visibleText )
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
		System.out.println("handling DropDown value is: "+visibleText);
				
	}
	
	
}
