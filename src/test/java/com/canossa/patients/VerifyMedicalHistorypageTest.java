package com.canossa.patients;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hms.genericLibrary.BaseClass;
import com.hms.genericLibrary.ExcelKeys;
import com.hms.genericLibrary.IConstantPath;


@Listeners(com.hms.genericLibrary.ListnerClass.class)
public class VerifyMedicalHistorypageTest extends BaseClass {
	@Test(retryAnalyzer = com.hms.genericLibrary.RetryImplementationClass.class)
	public void verifyMedicalHistorypageTest() {
		
		
		medicalHistory.medicalHistoryClickBtn();
		
		String actualtitle = driver.getTitle();
		String expectedtitle = excelLibrary.getExcelData(IConstantPath.EXCEL_PATH,ExcelKeys.MEDICAL_HISTORY.convertKeysToString(),1,1);
Assert.assertEquals(actualtitle, expectedtitle);
		
		Reporter.log("Medical history page is displayed and passed",true);
	}
		
	}

