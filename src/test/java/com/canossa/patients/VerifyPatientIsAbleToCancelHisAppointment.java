package com.canossa.patients;


import java.io.IOException;
import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.hms.genericLibrary.ExcelLibrary;
import com.hms.genericLibrary.IConstantPath;
import com.hms.genericLibrary.PropertyFileKeys;
import com.hms.genericLibrary.PropertyFileLibrary;
import com.hms.genericLibrary.WebDriverLibrary;
import com.hms.pom.BookAppointment;
import com.hms.pom.LoginPage;
import com.hms.pom.PatientModuleAppointmentHistoryPom;



public class VerifyPatientIsAbleToCancelHisAppointment {

	public static void main(String[] args) throws IOException {
		
		PropertyFileLibrary pro= new PropertyFileLibrary();
		WebDriverLibrary web= new WebDriverLibrary();

		String ExptedText = "Sam";
String browser = pro.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.BROWSER.getKey());
String url = pro.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
WebDriver driver= web.openApplication(browser,url);

		String username = pro.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey());
		String password = pro.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
		LoginPage log=new LoginPage(driver);
		log.loginASPatient(username, password);
	
		PatientModuleAppointmentHistoryPom app= new PatientModuleAppointmentHistoryPom(driver);
		app.AppointmentHistoryClick();
		
		BookAppointment book= new BookAppointment(driver);
		List<WebElement> doctorname = book.getDoctorNames();
	
	
	for(int i=0; i<doctorname.size(); i++)
	{
		String Actual = doctorname.get(i).getText();
	
		if(ExptedText.equals(Actual))
		{
			String value = driver.findElement(By.xpath("//td[.='"+ExptedText+"']/../td[7]")).getText();
			System.out.println(value);
			if("Active".contains(value))
			{
				driver.findElement(By.xpath("//td[.='"+ExptedText+"']/../td[8]/div/a")).click();
				Alert alert = driver.switchTo().alert();
			 System.out.println(alert.getText());
			 alert.accept();
				System.out.println("cancled");				
			}
			}
		}
	}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**for (int i=0; i<y;i++) {
		if(doctorname.equals("Sagar"))
		{
			String name=driver.findElement(By.xpath("//td[.='Sagar']/../td[7]")).getText();
			System.out.println(name);
		
			if(name.contains("Active")) 
			{

				driver.findElement(By.xpath("//td[.='Sagar']/../td[8]/div/a")).click();
				
			}
			else {
				System.out.println(name);
			}
		}
	}
	}
}
	
	
	
	
	/*	boolean b1=driver.findElement(By.xpath("//td [text()='Sam ']/../td[8]/div [normalize-space(text())='Canceled']")).isDisplayed();
		 if (b1==true) {
			System.out.println("already cancelled");
		}
		else {
		driver.findElement(By.xpath("//td [text()='Sam ']/..//a [text()='Cancel'")).click();
		Alert a= driver.switchTo().alert();
		a.accept();
		boolean b=driver.findElement(By.xpath("//p [normalize-space(text())='Your appointment canceled !!']")).isDisplayed();
		if (b==true){
			System.out.println("cancel appointment succesfull");
		}
		else {
			System.out.println("cancel appointment not successfull");
		}}
		fis.close();
		driver.close();
	}}*/


