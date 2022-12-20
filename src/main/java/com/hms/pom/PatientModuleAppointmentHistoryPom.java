package com.hms.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** this pom class contains web elements of Appointment history of patients Module and also it contains xpath.
 * @author Ram

*/
public class PatientModuleAppointmentHistoryPom {
	@FindBy(xpath="//span[text()=' Appointment History ']") private WebElement appointmentClickBtn;
	
	/** this method is used to click on appointment history module. 
	 * @param driver
	 */
	public PatientModuleAppointmentHistoryPom (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void AppointmentHistoryClick() {
		appointmentClickBtn.click();
		
		

	}	
}
