package com.hms.genericLibrary;
/** this class is containing property file keys and their methods. 
 * @author Ram Pandey
 */
public enum PropertyFileKeys {
	BROWSER("browser1"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout");
private String keys;
//setter
private PropertyFileKeys(String keys) {
	
this.keys=keys;

}
//getter
public String getKey() {
	return keys.toString();
}
}
