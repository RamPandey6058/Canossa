package com.hms.genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

/** this class is containing coverting methods for different datatypes
 * @author Ram Pandey
 */
public class JavaLibrary {
	/** this method is used to convert string to long
	 * @param data
	 * @return
	 */
public long convertStringToLong(String data) {
	long longData =Long.parseLong(data);
	return longData;	
	}
/** this method is used to convert string to int
 * @param data
 * @return
 */
	public int convertStringToInt(String data) {
	int intData=Integer.parseInt(data);
			return intData;
	}
/** this method is used to convert string to double
* @param data
* @return
*/

public double convertStringToDouble(String data) {
	double doubleData=Double.parseDouble(data);
	return doubleData;	
}
/** this method is used to get date and time in IST format
* @param data
 * @return 
* @return
*/
public String getCurrentDateTime() {
	Date date= new Date();
	return date.toString();
}
/** this method is used to get date and time in simple format
 * @return 
 */
public String getDateAndTime() {
	Date date= new Date();
	SimpleDateFormat sdf= new SimpleDateFormat();
	 return sdf.format(date);
	
}
}
