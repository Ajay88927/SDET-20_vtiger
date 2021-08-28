package com.vtiger.genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Its used to read common data from Properties file
 * 
 * @author ajayb
 *
 */
public class FileUtitlity {
	/**
	 * its used to read the data from commonData.properties File based on Key which
	 * you pass as an argument
	 * 
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}
}
