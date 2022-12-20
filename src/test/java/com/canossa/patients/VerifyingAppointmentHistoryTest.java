package com.canossa.patients;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.genericLibrary.BaseClass;
import com.hms.genericLibrary.ExcelKeys;
import com.hms.genericLibrary.IConstantPath;
import com.hms.pom.PatientModuleAppointmentHistoryPom;
@Listeners(com.hms.genericLibrary.ListnerClass.class)
public class VerifyingAppointmentHistoryTest extends BaseClass {

	@Test
	
	public void verifyingAppointmentHistoryTest() {

		PatientModuleAppointmentHistoryPom app= new PatientModuleAppointmentHistoryPom(driver);
		app.AppointmentHistoryClick();
		String actualtitle= driver.getTitle();

		String expectedtitle = excelLibrary.getExcelData(IConstantPath.EXCEL_PATH,ExcelKeys.APPOINTMENT_HISTORY.convertKeysToString(),2,1);
		Assert.assertEquals(actualtitle, expectedtitle);
		Reporter.log("appointment history page is displaying and passed ",true);
			
	}
}
