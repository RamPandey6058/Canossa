package com.hms.canossa.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SqlServerTest {

	public static void main(String[] args) throws SQLException {
	Driver driverref= new Driver();
	DriverManager.registerDriver(driverref);
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile","root","root");
	Statement stat= con.createStatement();
String query="insert into mobile(mobile_name,brand_name,price)values ('galaxy m44','samsung','1090')";
int result=stat.executeUpdate(query);
if (result==1) {
	System.out.println("mobile is created");
	}
	else {
		System.out.println("mobile is not created");
	}
	con.close();
}
	}
