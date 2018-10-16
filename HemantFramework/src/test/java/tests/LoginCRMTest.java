package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginCRMPage;
import pages.LogoutCRMPage;

public class LoginCRMTest extends LoginCRMPage{

	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void setupTest() {
		//System.out.println("TEST STARTED...");
	}
	
	@Test(priority=1)
	public void LoginTest() {
		
		LoginCRM();

		softAssert.assertEquals(driver.getTitle(), "CRMPRO");
		
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void verifyTitleTest() {
		//System.out.println("STARTING verifyTitleTest");
		
		LogoutCRMPage logoutPage = new LogoutCRMPage();	
		
		//System.out.println(driver.getTitle());
		
		softAssert.assertEquals(driver.getTitle(), "CRMPRO");

		logoutPage.LogoutCRM();

		softAssert.assertEquals(driver.getTitle(), "#1 Free CRM software in the cloud for sales and service");
		
		softAssert.assertAll();

		//System.out.println("Logout success...");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("executing tear down after class");
		driver.quit();
		driver=null;
	}

}