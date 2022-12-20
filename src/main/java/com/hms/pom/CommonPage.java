package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** this  pom class contains web elements of common page of patients Module and also it contains xpath of it.
* @author Ram Pandey
*/

public class CommonPage {
	@FindBy(xpath="//span [@class='username']") private WebElement logOutPage;
@FindBy(xpath="//a[normalize-space(text())='Log Out']") private WebElement logOutClickBtn;


public CommonPage (WebDriver driver) {
	PageFactory.initElements(driver, this);
}

/**
 * this method is used to click on logout button
 */
public void logOutClickBtn() {
	logOutPage.click();
logOutClickBtn.click();
}
}