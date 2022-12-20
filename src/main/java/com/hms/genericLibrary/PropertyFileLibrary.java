package com.hms.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {
	
	private FileInputStream Propertyfis;
	/**
	 * this method is used to fetch the data from property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws io exception, used try and catch.
	 */
	public String getPropertyFileData(String path,String key) {
	try {
		Propertyfis = new FileInputStream(path);
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	Properties p= new Properties();
	try {
		p.load(Propertyfis);
	} catch (IOException e) {
		e.printStackTrace();
	}
	String data = p.getProperty(key).trim();
	return data;
}
	
	/** this method is used to close the property file
	 * @throws IOException
	 */
	public void closePropertyFile() throws IOException {
		// TODO Auto-generated method stub
		Propertyfis.close();
	}
}