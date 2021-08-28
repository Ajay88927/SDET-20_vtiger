package com.vtiger.genericutilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains webdriver specific generic methods
 * 
 * @author ajayb
 *
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method waits for 20 sec for page loading
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method waits for 20 sec for the element to be visible
	 * 
	 * @param driver
	 * @param ele
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * This method waits for the element to be clicked, it's a custom wait created
	 * to avoid elemenInterAceptable Exception
	 * 
	 * @param ele
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement ele) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				ele.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This methods enables user to handle dropdown using visible text
	 * 
	 * @param ele
	 * @param option
	 */
	public void select(WebElement ele, String option) {
		Select select = new Select(ele);
		select.selectByVisibleText(option);
	}

	/**
	 * This methods enables user to handle dropdown using index
	 * 
	 * @param ele
	 * @param index
	 */
	public void select(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);
	}

	/**
	 * This method will perform mouse over action
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}

	/**
	 * This method performs right click operation
	 * 
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
	}

//	public void switchToWindow(WebDriver driver, String partialWinTitle) {
//		Set<String> allWid = driver.getWindowHandles();
//		Iterator<String> iterator = window.iterator();
//	}

	/**
	 * Accept alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * It is used to get alert text
	 * @param driver
	 * @return
	 */
	public String alertText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	

	/**
	 * Cancel Alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method used for scrolling action in a webpage
	 * 
	 * @param driver
	 * @param ele
	 */
	public void scrollToWebElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = ele.getLocation().getY();
		jse.executeScript("window.scrollBy(0," + y + ")", ele);
	}

	/**
	 * This method used switch to frames in a webpage using webElement
	 * 
	 * @param driver
	 * @param ele
	 */
	public void switchToframe(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * This method used switch to frames in a webpage using Id or Name
	 * 
	 * @param driver
	 * @param IDOrName
	 */
	public void switchFrameId(WebDriver driver, WebElement IDOrName) {
		driver.switchTo().frame(IDOrName);
	}

	public void takeScreenShot(WebDriver driver, String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScrreeenShots/" + screenShotName + ".PNG");
//		Fileco
	}

	/**
	 * pass enter Key in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER);
	}
}
