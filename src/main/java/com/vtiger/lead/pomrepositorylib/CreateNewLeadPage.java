package com.vtiger.lead.pomrepositorylib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.genericutilities.WebDriverUtility;

public class CreateNewLeadPage extends WebDriverUtility {
	WebDriver driver;

	public CreateNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveLink;
	
//	@FindBy(name = "salutationtype")
//	private WebElement salut;
	
	@FindBy(name = "firstname")
	private WebElement firstname;
	
	@FindBy(name = "lastname")
	private WebElement lname;
	
	@FindBy(name = "company")
	private WebElement comp;
	
	@FindBy(id = "noofemployees")
	private WebElement numOfEmp;
	
	@FindBy(xpath = "//span[text()='Creating New Lead']")
	private WebElement createNewLeadText;
	
//	@FindBy(id = "designation")
//	private WebElement design;
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getCreateNewLeadPage() {
		return createNewLeadText;
	}

	public WebElement getLeadSrcDropDown() {
		return leadSrcDropDown;
	}

	public WebElement getNumOfEmp() {
		return numOfEmp;
	}

	public WebElement getComp() {
		return comp;
	}

	public WebElement getLname() {
		return lname;
	}

	@FindBy(name = "leadsource")
	private WebElement leadSrcDropDown;
	
	public WebElement getSaveLink() {
		return saveLink;
	}
	
//	public WebElement getSalut() {
//		return salut;
//	}

	public WebElement getFname() {
		return firstname;
	}

//	public WebElement getDesign() {
//		return design;
//	}

	public WebElement getLeadsrc() {
		return leadSrcDropDown;
	}
	
	public void createLeaadByLeavingALLFieldsBlank() {
		saveLink.click();
	}
	
	public void createLeaadLeavingMandatoryFieldsBlank(int numOfEmployees) {
		String noe = String.valueOf(numOfEmployees);
		numOfEmp.sendKeys(noe);
		saveLink.click();
	}
	public void createLeadWithDiffLeadSource(String fname, String lastName, String compName, String leadSrc) {
//		salut.sendKeys(null);
		firstname.sendKeys(fname);
		lname.sendKeys(lastName);
		comp.sendKeys(compName);
		
		WebDriverUtility wLib =new WebDriverUtility();
		wLib.select(leadSrcDropDown, leadSrc);
		saveLink.click();
	}
	
	public void createNewLead(String lastName, String company) {
		lname.sendKeys(lastName);
		comp.sendKeys(company);
		saveLink.click();
	}
}
