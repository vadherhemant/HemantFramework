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
		// logConsoleMessage("TEST STARTED...");
	}

	@Test(priority = 1, description = "This test will assert page title after logging into site")
	public void LoginTest() {
		LoginCRM();
		softAssert.assertEquals(driver.getTitle(), "CRMPRO");
		softAssert.assertAll();
	}

	@Test(priority = 2, alwaysRun = true, description = "This test will assert login success and logout success using page title verification")
	public void verifyTitleTest() {

		LogoutCRMPage logoutPage = new LogoutCRMPage();

		softAssert.assertEquals(driver.getTitle(), "CRMPRO");

		logoutPage.LogoutCRM();

		softAssert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");

		softAssert.assertAll();
	}

	@AfterClass(enabled = true)
	public void tearDown() {
		stopBrowser();
	}

}