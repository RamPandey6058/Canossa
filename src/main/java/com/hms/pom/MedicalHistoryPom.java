package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** this  pom class contains web elements of Appointment history of patients Module and also it contains xpath.
 * 
 * @author Ram Pandey
 
 */
public class MedicalHistoryPom {
@FindBy(xpath="//span [text()=' Medical History ']") private WebElement medicalHistoryClickBtn;
/** this method is used to click on medical history module. 
 * 
 */
	public MedicalHistoryPom (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void medicalHistoryClickBtn () {
		medicalHistoryClickBtn.click();

	}	
}



