package com.canossa.patients;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.hms.genericLibrary.BaseClass;
import com.hms.genericLibrary.ExcelKeys;
import com.hms.genericLibrary.IConstantPath;

public class DataFlowBetweenAppointmentHistoryandDoctorModule_IT extends BaseClass{
	@Test
	public void dataFlowBetweenAppointmentHistoryandDoctorModule_IT(){

		
		
		bookAppointment.bookAppointementClickBtn();
	
		String Doctorspecilization = excelLibrary.getExcelData(IConstantPath.EXCEL_PATH,ExcelKeys.APPOINTMENT_HISTORY.convertKeysToString(), 5, 1);

	WebElement docSpec = driver.findElement(By.name("Doctorspecialization"));
	Select s=new Select(docSpec);
	s.selectByVisibleText(Doctorspecilization);

	String Doctorname=excelLibrary.getExcelData(IConstantPath.EXCEL_PATH,ExcelKeys.APPOINTMENT_HISTORY.convertKeysToString(), 5, 2);
	WebElement docname = driver.findElement(By.name("doctor"));
	Select s1 = new Select(docname);
	s1.selectByVisibleText(Doctorname);

	bookAppointment.enterDate(excelLibrary.getExcelData(IConstantPath.EXCEL_PATH,ExcelKeys.APPOINTMENT_HISTORY.convertKeysToString(),5, 3));
	bookAppointment.enterTime(excelLibrary.getExcelData(IConstantPath.EXCEL_PATH,ExcelKeys.APPOINTMENT_HISTORY.convertKeysToString(), 5, 4));
	bookAppointment.submitClickBtn();
 
 Alert a = driver.switchTo().alert();
 a.accept();
 int count=0;
 
 patientModuleAppointmentHistoryPom.AppointmentHistoryClick();
 List<WebElement> doctorsname = bookAppointment.getDoctorNames();
 List<WebElement> specialization = bookAppointment.getdoctorSpecialization();
for(int i=doctorsname.size()-1;i>=0;i--)
{
	if(doctorsname.get(i).getText().equals(Doctorname) && specialization.get(i).getText().equals(Doctorspecilization))
	{
		System.out.println("pass");
		count++;
		break;
	}	
}
if (count==0) {
	System.out.println("fail");
}
	}

}
	