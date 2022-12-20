package com.hms.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** this  pom class contains web elements of book appointment patients Module and also it contains xpath.
 * @author Ram Pandey 
 */


public class BookAppointment {
@FindBy(xpath="//span [text()=' Book Appointment ']") private WebElement bookAppointmentClickBtn;
@FindBy(xpath="//button[@name='submit']") private WebElement submitClickBtn;
@FindBy(xpath="//table/tbody/tr/td[@class='hidden-xs']") private List<WebElement> doctorNames;
@FindBy(xpath="//table/tbody/tr/td[3]") private List<WebElement> doctorSpecializations;
@FindBy(xpath="//input[@name='appdate']") private WebElement enterDate; 
@FindBy (xpath="//input[@id='timepicker1']") private WebElement enterTime;

/** this method is used to click on book appointment.  
 * @param driver
 */
public BookAppointment (WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void bookAppointementClickBtn() {
	bookAppointmentClickBtn.click();

}	
/** this method is used to click on submit button of book appointment module.  
 * @param driver
 */
public void submitClickBtn () {
	submitClickBtn.click();
}
public List<WebElement> getDoctorNames() {
	return doctorNames;
}
public List<WebElement> getdoctorSpecialization() {
	return doctorSpecializations;
	
}
public void enterDate(String date) {
enterDate.sendKeys(date);
enterDate.click();
}
public void enterTime(String time) {
enterTime.sendKeys(time);
enterTime.click();
}
}
