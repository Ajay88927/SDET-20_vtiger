package com.vtiger.lead.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadImg;
	
//	@FindBy(xpath = "//a[text()='']")
//	private WebElement lead;
	
	@FindBy(linkText = "Gowda372")
	private WebElement lead;
	
	public WebElement getLead() {
		return lead;
	}

	public WebElement getCreateLeadImg() {
		return createLeadImg;
	}
}
