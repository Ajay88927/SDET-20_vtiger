package com.vtiger.lead.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericutilities.JavaUtility;
import com.vtiger.genericutilities.WebDriverUtility;

public class LeadInfoPage {
	WebDriver driver;

	public LeadInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Lead Source']/font")
	private WebElement leadType;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement successMsg;
	
	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadLink;
	
	@FindBy(id = "select_account")
	private WebElement orgCheckBox;
	
	@FindBy(id = "select_potential")
	private WebElement oppCheckBox;
	
	@FindBy(id  = "jscal_field_closedate")
	private WebElement expClosDate;
	
	@FindBy(xpath = "//input[@name='Save']")
	private WebElement convertLeadSaveLink;
	
	@FindBy(id = "select_contact")
	private WebElement contactCheckBox;
	
	public WebElement getConvertLeadSaveLink() {
		return convertLeadSaveLink;
	}

	public WebElement getExpClosDate() {
		return expClosDate;
	}

	public WebElement getConvertSaveLink() {
		return convertLeadSaveLink;
	}

	public WebElement getConvertLeadLink() {
		return convertLeadLink;
	}

	public WebElement getOrgCheckBox() {
		return orgCheckBox;
	}

	public WebElement getOppCheckBox() {
		return oppCheckBox;
	}

	public WebElement getConCheckBox() {
		return contactCheckBox;
	}
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public WebElement getLeadType() {
		return leadType;
	}

	public WebElement getLeadSuccessMsg() {
		return successMsg;
	}
	
	public void convertLeadToOpportunitySelectAllCheckBox() {
		convertLeadLink.click();
		oppCheckBox.click();
		JavaUtility jLib = new JavaUtility();
		String date = jLib.getSystemDateTime_YYY();
		expClosDate.sendKeys(date);
		convertLeadSaveLink.click();
	}
	
	public void ConvertLeadToOpertunitiesSelectOrganisationCheckbox() {
		convertLeadLink.click();
		if(contactCheckBox.isSelected()) {
			contactCheckBox.click();
		}
		convertLeadSaveLink.click();
	}
}
