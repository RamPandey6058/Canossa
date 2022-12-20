package com.hms.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/** This class contains Driver launching Methods
 * @author Ram Pandey
 */

public class WebDriverLibrary {
WebDriver driver;
/** This method launches the application and maximizes the application
 *  @param browser
 *  @return
 *  
 */
public WebDriver openApplication(String browser, String url) {
if (browser.equals("chrome")){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	BaseClass.sdriver= driver;
}
else if (browser.equals("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver= new FirefoxDriver();
	BaseClass.sdriver = driver;
}
else {
	System.out.println("enter valid browser name");
}
driver.manage().window().maximize();
driver.get(url);
return driver;
}
 /**
  * wait for page to load before identifying any synchronized element in DOM [HTML- Document]
  * @param
  */
public void waitForPageToLoad (WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
/**
 * wait for page to load before identifying any asynchronized [java scripts actions]element in DOM [HTML Document]
 * @param
 */
public void waitForPageToLoadForJSElement(WebDriver driver) {
	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
}
/**
 * this method is used to quit the browser
 */
public void closeApplication() {
	driver.quit();
	} 
/**
 * this method is used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * this method is used to wait for element to be clickable in GUI, &check for specific element for every 500 milli seconds 
 * @param driver
 * @param element
 * @param pollingTime
 * @throws InterruptedException
 */
public void waitForElementWithCustomTimeout(WebDriver driver,WebElement element,int pollingTime) throws InterruptedException {
	FluentWait wait = new FluentWait(driver);
	wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
	wait.wait(20);
	wait.until(ExpectedConditions.elementToBeClickable(element));	
}
/**
 * this method is used to switch to any window based on window Title
 * @param driver
 * @param partialWindowTitle
 */
 public void switchToWindow(WebDriver driver,String partialWindowTitle) {
	 Set<String> set = driver.getWindowHandles();
	Iterator<String> iterator = set.iterator();
	 while (iterator.hasNext()) {
		 String wID=iterator.next();
		 driver.switchTo().window(wID);
		 String currentWindowTitle = driver.getTitle();
		 if(currentWindowTitle.contains(partialWindowTitle)) {
			 break;
		 }
	 } 
 }
 /**
  * this method is used to switch to alert window & click on accept button
  * @param driver
  */
 public void acceptAlert(WebDriver driver) {
	 driver.switchTo().alert().accept();
 }
/**
 * this method is used to switch to alert window & click on dismiss button
 * @param driver
 */
 public void dismissAlert(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
 }
 /**
  * this method is used to switch to frame window based on index 
  * @param index
  * @param driver
  */
 public void switchToFrame(int index, WebDriver driver) {
	 driver.switchTo().frame(index);
 }
 /**
  * this method is used to switch to frame window based on id, name, attribute
  * @param driver
  * @param Name_id_attribute
  */
 public void switchToFrame(WebDriver driver,String Name_id_attribute) {
	 driver.switchTo().frame(Name_id_attribute);
 }
 /** 
  * this method is used to select the value from the dropdown based on index
  * @param driver
  * @param element
  * @param index
  */
 public void select( WebElement element, int index) {
	 Select sel= new Select(element);
	 sel.selectByIndex(index);
 }
 /**
  * this method is used to select the value from the dropdown based on value/option availablein GUI
  * @param element
  * @param text
  */
 public void select (WebElement element,String text) {
	 Select sel= new Select(element);
	 sel.selectByVisibleText(text);
 }
 /**
  * this method is used to place the mouse cursor on specified element
  * @param driver
  * @param element
  */
 public void mouseHoverOnElement(WebDriver driver,WebElement element) {
	 Actions act= new Actions(driver);
	 act.moveToElement(element).perform();	 
 }
 /**
  * this method is used to right click on specified element 
  * @param driver
  * @param element
  */
 public void rightClickOnElement(WebDriver driver, WebElement element) {
	 Actions act= new Actions(driver);
	 act.contextClick(element).perform();
 }
/**
 * This method is used to take screenshot of webpage and stored in local system
 * @param testCaseName
 * @return
 * @throws IOException
 */
public String takeScreenshot (String testCaseName) throws IOException{
	String fileName= testCaseName+"_"+new JavaLibrary().getDateAndTime();
TakesScreenshot ts= (TakesScreenshot) driver;
File src= ts.getScreenshotAs(OutputType.FILE);
File dst=new File("./errorshots/"+fileName+".png");
Files.copy(src, dst);
return dst.getAbsolutePath();
}
}