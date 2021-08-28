package com.vtiger.leadtest.createlead;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutilities.BaseClass;
import com.vtiger.genericutilities.ExcelUtility;
import com.vtiger.genericutilities.JavaUtility;
import com.vtiger.lead.pomrepositorylib.CreateNewLeadPage;
import com.vtiger.lead.pomrepositorylib.HomePage;
import com.vtiger.lead.pomrepositorylib.LeadInfoPage;
import com.vtiger.lead.pomrepositorylib.LeadsPage;


@Listeners(com.vtiger.genericutilities.ListenerImplementationClass.class)
public class CreatNewLeadTest extends BaseClass {
	
	@Test(groups = {"SmokeTest"})
	public void createLeadAllFieldBlankTest() throws Throwable {
		boolean homePageTitle = driver.getTitle().contains("Home");
		Assert.assertTrue(homePageTitle);
		
		// navigate to leads
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		// navigate to create leads
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();
		
		// Create lead
		CreateNewLeadPage newLeadPage = new CreateNewLeadPage(driver);
		boolean createNewLeadTitle = newLeadPage.getCreateNewLeadPage().getText().equals("Creating New Lead");
		Assert.assertTrue(createNewLeadTitle);
		newLeadPage.createLeaadByLeavingALLFieldsBlank();
		
		String expectedAlertText = eLib.getDataFromExcel("Sheet1", 1, 24);
		String actualAlertText = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();
		
		// Verification w.r.t success msg
//		if (actualAlertText.equals(expectedAlertText)) {
//			System.out.println("PASS: Last Name cannot be empty message displayed");
//			eLib.setDataIntoExcel("Sheet1", 1, 25, "PASS");
//		} else {
//			System.out.println("FAIL: Last Name cannot be empty message not displayed");
//			eLib.setDataIntoExcel("Sheet1", 1, 25, "FAIL");
//		}
		
//		test = reports.createTest("createLeadAllFieldBlankTest");
		Assert.assertEquals(actualAlertText, expectedAlertText);
		
	}
	
	@Test(groups = {"SmokeTest", "regressionTest"})
	public void creatLeadLeavingMandatoryFieldTest() throws Throwable {
		boolean homePageTitle = driver.getTitle().contains("Home");
		Assert.assertTrue(homePageTitle);
		
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();

		CreateNewLeadPage cnlPage = new CreateNewLeadPage(driver);
		cnlPage.createLeaadLeavingMandatoryFieldsBlank(20);

		//Reading data from excel
		String expectedAlertText = eLib.getDataFromExcel("Sheet1", 2, 24);
		
		String actualAlertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

//		if (actualAlertText.equals(expectedAlertText)) {
//			System.out.println("PASS: Alert Text is Correct");
//			eLib.setDataIntoExcel("Sheet1", 2, 25, "PASS");
//		} else {
//			System.out.println("FAIL: Alert Text is InCorrect");
//			eLib.setDataIntoExcel("Sheet1", 2, 25, "FAIL");
//		}
//		test = reports.createTest("creatLeadLeavingMandatoryFieldTest");
		Assert.assertEquals(actualAlertText, expectedAlertText);
	}

	@Test(groups = {"regressionTest"})
	public void CreatLeadDiffLeadSrcTest() throws Throwable {
		// Object creation for Libraries
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();

		int randomInt = jLib.getRandomNumber();

		// Data from Excel
		String firstName = eLib.getDataFromExcel("Sheet1", 3, 3) + randomInt;
		String lastName = eLib.getDataFromExcel("Sheet1", 3, 22) + randomInt;
		String companyName = eLib.getDataFromExcel("Sheet1", 3, 23) + randomInt;
		String leadSourceType = eLib.getDataFromExcel("Sheet1", 3, 5);

		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadImg().click();

		CreateNewLeadPage cnlPage = new CreateNewLeadPage(driver);
		cnlPage.createLeadWithDiffLeadSource(firstName, lastName, companyName, leadSourceType);

		// Verification w.r.t lead
		LeadInfoPage leadInfo = new LeadInfoPage(driver);
		boolean actualSucessMsg = leadInfo.getLeadSuccessMsg().getText().contains(firstName);
		
//		if (actualSucessMsg.contains(firstName)) {
//			System.out.println("PASS: New Lead created successfully");
//		} else {
//			System.out.println("FAIL: New Lead not created Successfully");
//		}
		Assert.assertTrue(actualSucessMsg);

		// Verification w.r.t lead Source Type
		boolean actualLeadType = leadInfo.getLeadType().getText().contains(leadSourceType);
//		if (actualLeadType.contains(leadSourceType)) {
//			System.out.println("PASS: " + leadSourceType + " selected successfully");
//			eLib.setDataIntoExcel("Sheet1", 3, 25, "PASS");
//		} else {
//			System.out.println("FAIL: " + leadSourceType + " not selected successfully");
//			eLib.setDataIntoExcel("Sheet1", 3, 25, "FAIL");
//		}
//		test = reports.createTest("CreatLeadDiffLeadSrcTest");
		Assert.assertTrue(actualLeadType);
	}
}
