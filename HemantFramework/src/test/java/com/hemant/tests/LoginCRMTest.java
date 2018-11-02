package com.hemant.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hemant.pages.LoginCRMPage;
import com.hemant.pages.LogoutCRMPage;

public class LoginCRMTest extends LoginCRMPage {

	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setupTest() {
		// System.out.println("TEST STARTED...");
	}

	@Test(priority = 1)
	public void LoginTest() {
		LoginCRM();
		softAssert.assertEquals(driver.getTitle(), "CRMPRO");
		softAssert.assertAll();
	} 

	@Test(priority = 2)
	public void verifyTitleTest() {

		LogoutCRMPage logoutPage = new LogoutCRMPage();

		softAssert.assertEquals(driver.getTitle(), "CRMPRO");

		logoutPage.LogoutCRM();

		softAssert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");

		softAssert.assertAll();
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}