package com.hms.genericLibrary;


import org.testng.annotations.BeforeMethod;

import com.hms.pom.BookAppointment;
import com.hms.pom.CommonPage;
import com.hms.pom.LoginPage;
import com.hms.pom.MedicalHistoryPom;
import com.hms.pom.PatientModuleAppointmentHistoryPom;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	protected ExcelKeys excelKeys;
	protected ExcelLibrary excelLibrary;
	protected IConstantPath iconstantPath;
	protected JavaLibrary javaLibrary;
	protected PropertyFileKeys propertyFileKeys;
	protected PropertyFileLibrary propertyFileLibrary;
	protected WebDriverLibrary webDriverLibrary;
	protected LoginPage loginpage;
	protected CommonPage commonPage;
    protected WebDriver driver;
	protected BookAppointment bookAppointment;
	protected MedicalHistoryPom medicalHistory;
	protected PatientModuleAppointmentHistoryPom patientModuleAppointmentHistoryPom;
	protected static WebDriver sdriver;
	
 /**
  * create object for generic library
  * read data from property file
  * open excel file
  * launch browser,application and setup browser
  * create object for common pom classes 
  * @throws IOException
  * @throws EncryptedDocumentException
  */
	
  @BeforeClass
  public void classSetup() {
	  //create object for generic library
	  excelLibrary= new ExcelLibrary();
	  javaLibrary=new JavaLibrary();
	  propertyFileLibrary= new PropertyFileLibrary();
	  webDriverLibrary = new WebDriverLibrary();
	 
	  
	  //read data from property file
	  String browser = propertyFileLibrary.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.BROWSER.getKey());
	  String url = propertyFileLibrary.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.URL.getKey());
	  
	  
	  //open excel file
	 // excelLibrary.openExcel(IConstantPath.EXCEL_PATH);
	  
	  //launch browser ,application and setup browser
	  driver = webDriverLibrary.openApplication(browser, url);
	
	  
	  //create an object for common pom classes 
	  loginpage = new LoginPage(driver);
	  commonPage= new CommonPage(driver);
	  bookAppointment = new BookAppointment(driver);
	  medicalHistory = new MedicalHistoryPom(driver);
	  patientModuleAppointmentHistoryPom= new PatientModuleAppointmentHistoryPom(driver);
  }
/**
 * used to login application 
 * 
 */
@BeforeMethod
public void methodSetup() {
	String username=propertyFileLibrary.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey());
	String password = propertyFileLibrary.getPropertyFileData(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
	loginpage.loginASPatient(username, password);
}

@AfterMethod
public void methodTearDown() {
	commonPage.logOutClickBtn();
}

/**
 * used to cloae the browser and close property file and excel file
 * @throws IOException
 */

  @AfterClass
  public void classTearDown() {
	  webDriverLibrary.closeApplication(); 
  }
}
