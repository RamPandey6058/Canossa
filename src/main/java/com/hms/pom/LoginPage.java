package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** this  pom class contains web elements of login page of patients Module and login button  and also it contains xpath of it.
* @author Ram Pandey
*/

public class LoginPage {
	
	@FindBy(xpath="//h3[text()='Doctors Login']/parent::div//a") private WebElement doctorClickBtn;
	@FindBy(xpath ="//h3[text()='Patients']/parent::div//a") private WebElement patientClickBtn;
	@FindBy(xpath ="//h3[text()='Admin Login']/parent::div//a") private WebElement adminClickBtn;
	
	//Patient Login Page 
	@FindBy(name="username") private WebElement patientUSNTxtBx;
	@FindBy(name ="password") private WebElement patientPWDTxtBx ;
	@FindBy(name ="submit") private WebElement patientLoginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/** this method is used to send the username and password and also click on login button 
	 *  @param patientUsername
	 * @param patientPassword
	 */
	public void loginASPatient(String patientUsername,String patientPassword) {
patientClickBtn.click();
patientUSNTxtBx.sendKeys(patientUsername);
patientPWDTxtBx.sendKeys(patientPassword);
patientLoginBtn.click();
	}
}
