package com.hms.genericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	int counter =0;
	int retrylimit=4;
	
	public boolean retry(ITestResult result) {
		if(counter<(retrylimit)) {
			counter++;
			return true;
			
		}
		return false;
	}

}