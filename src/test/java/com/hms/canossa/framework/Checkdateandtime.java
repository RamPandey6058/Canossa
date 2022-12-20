package com.hms.canossa.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hms.genericLibrary.JavaLibrary;

public class Checkdateandtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JavaLibrary javalib = new JavaLibrary();
String date = javalib.getCurrentDateTime();
System.out.println(date);
String data = javalib.getDateAndTime();

System.out.println(data);
	}

}
