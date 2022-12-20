package com.hms.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testScriptName = result.getName();
		EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sdriver);
	 File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	 File destFile = new File("./screenshot/"+testScriptName+".png");
	 try {
		 FileUtils.copyFile(srcFile, destFile);
	 }catch (IOException e) {
		 e.printStackTrace();
	 }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	
	

}
