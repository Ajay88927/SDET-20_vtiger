package com.vtiger.genericutilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic libraries
 * 
 * @author ajayb
 *
 */
public class JavaUtility {
	/**
	 * Its used to generate random integer numbers within the boundary og 0 to 1000
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}

	/**
	 * Its used to get the current system date & time
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		String systemDateTime = date.toString();
		return systemDateTime;
	}

	/**
	 * Its used to get the current System date with YYYY-MM-DD format
	 * 
	 * @return
	 */
	public String getSystemDateTime_YYY() {
		Date date = new Date();
		String systemDatewithFormat = date.toString();
		String[] arr = systemDatewithFormat.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth() + 1;

		String DateTimeFormat = YYYY + "-" + MM + "-" + DD;
		return DateTimeFormat;
	}
	
	/**
	 * Its used to pass Virtual Key to OS
	 * @throws AWTException
	 */
	public void VirtualEnterKey() throws AWTException {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}
}
