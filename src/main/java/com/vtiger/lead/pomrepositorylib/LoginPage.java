package com.vtiger.lead.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement userNameTF;

	@FindBy(name = "user_password")
	private WebElement passwordTF;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void login(String Username, String Password) {
		userNameTF.sendKeys(Username);
		passwordTF.sendKeys(Password);
		loginBtn.click();
	}
}
