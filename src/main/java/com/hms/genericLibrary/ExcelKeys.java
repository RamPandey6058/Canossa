package com.hms.genericLibrary;
/** This class is containing Excel keys
 * @author Ram Pandey
 */
public enum ExcelKeys {

	APPOINTMENT_HISTORY("Appointment History"),MEDICAL_HISTORY("Medical History");
	private String keys;
	private ExcelKeys(String keys) {
		this.keys=keys;
	}
	
	
public String convertKeysToString() {
	return keys.toString();
}
}
