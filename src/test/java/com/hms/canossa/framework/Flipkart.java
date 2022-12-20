package com.hms.canossa.framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
static {
WebDriverManager.chromedriver().setup();
}
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button [@class='_2KpZ6l _2doB4z']")).click();
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	List<WebElement> productList = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='_4rR01T']/../..//div[@class='_30jeq3 _1_WHN1']"));
	for(int i=0;i<productList.size();i++) {
		String name = productList.get(i).getText();
	String price=productPrice.get(i).getText();
	System.out.println(name+"------------------>"+price);
		
	}
	}

}
