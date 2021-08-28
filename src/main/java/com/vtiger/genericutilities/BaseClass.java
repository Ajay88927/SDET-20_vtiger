package com.vtiger.genericutilities;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.lead.pomrepositorylib.HomePage;
import com.vtiger.lead.pomrepositorylib.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	//Object creation for Lib
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtitlity fLib = new FileUtitlity();
	public ExcelUtility eLib = new ExcelUtility();
	
//	public ExtentHtmlReporter reporter;
//	public ExtentReports reports;
//	public ExtentTest test;

	@BeforeSuite(groups = {"SmokeTest", "regressionTest"})
	public void configBS() {
		String ldt = LocalDateTime.now().toString().replace(":", "-");
//		reporter = new ExtentHtmlReporter("./VtigerProject/ExtentReports/CreateNewLeadReports"+ldt+".html");
//		reports = new ExtentReports();
//		reports.attachReporter(reporter);
//		
//		reporter.config().setDocumentTitle("Create New Lead Test Report");
//		reporter.config().setTheme(Theme.DARK);
		System.out.println("====JDBC Connection Before Suite=======");
	}

	@BeforeClass(groups = {"SmokeTest", "regressionTest"})
	public void configBC() {
		System.out.println("=====Launching Browser=======");
		// Object creation for Utilities
		driver = new ChromeDriver();
		wLib.maximizeBrowser(driver);
		wLib.waitUntilPageLoad(driver);
		sDriver=driver;
	}
	
//	@Parameters("Browser")
//	@BeforeClass
//	public void configBC(String Browser) {
//		System.out.println("=====Launching Browser=======");
//		// Object creation for Utilities
//		if(Browser.equals("chrome")) {
//			driver=new ChromeDriver();
//		}else if(Browser.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}else if(Browser.equals("msedge")) {
//			driver=new EdgeDriver();
//		}
//		
//		wLib.maximizeBrowser(driver);
//		wLib.waitUntilPageLoad(driver);
//	}

	@BeforeMethod(groups = {"SmokeTest", "regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("=======Login to Application=====");
		// Common Data
		String Browser = fLib.getPropertyKeyValue("browser");
		String Url = fLib.getPropertyKeyValue("url");
		String Username = fLib.getPropertyKeyValue("username");
		String Password = fLib.getPropertyKeyValue("password");

		//Navigate to app
		driver.get(Url);
		//Login to app
		LoginPage lp = new LoginPage(driver);
		lp.login(Username, Password);
	}
	
	@AfterMethod(groups = {"SmokeTest", "regressionTest"})
	public void configAM() {
		System.out.println("===Logout from Application====");
		//Logout
		HomePage hp = new HomePage(driver);
		hp.signOut();

	}

	@AfterClass(groups = {"SmokeTest", "regressionTest"})
	public void configAC() {
		System.out.println("========Close the Browser========");
		driver.quit();
	}

	@AfterSuite(groups = {"SmokeTest", "regressionTest"})
	public void configAS() {
//		reports.flush();
		System.out.println("====Closing JDBC Connection After Suite=======");
	}
}
