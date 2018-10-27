package com.hemant.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hemant.extentreports.ExtentTestManager;
import com.hemant.pages.LoginCRMPage;
import com.hemant.pages.LogoutCRMPage;


public class LoginCRMTest extends LoginCRMPage{

	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void setupTest() {
		//System.out.println("TEST STARTED...");
		//ExtentTestManager.startTest("setupTest", "start the setup of the test");
		
		//ExtentTestManager.getTest().setDescription("Inside verify Title Test FROM EXTENT");
	}
	
	@Test(priority=1)
	public void LoginTest() {
		
		ExtentTestManager.getTest().setDescription("Inside Login Test message from Extent Test Manager.getTest");

		LoginCRM();

		softAssert.assertEquals(driver.getTitle(), "CRMPRO");
		
		softAssert.assertAll();

	}
	
	@Test(priority=2)
	public void verifyTitleTest() {
		
		//ExtentTestManager.getTest().setDescription("Inside verify Title Test FROM EXTENT");

		LogoutCRMPage logoutPage = new LogoutCRMPage();	

		softAssert.assertEquals(driver.getTitle(), "CRMPRO");

		logoutPage.LogoutCRM();

		softAssert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");

		softAssert.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		//ExtentTestManager.endTest();
		//System.out.println("executing tear down after class");
		driver.quit();
		driver=null;
	}

}