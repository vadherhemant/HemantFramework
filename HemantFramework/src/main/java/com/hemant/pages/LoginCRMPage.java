package com.hemant.pages;

import org.openqa.selenium.WebElement;



import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hemant.browserfactory.BasePage;
import com.hemant.webelements.ElementAction;


public class LoginCRMPage extends BasePage {

	
	@FindBy(how = How.NAME, using = "username")
	private WebElement UsernameLocator;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	private WebElement PasswordLocator;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement SubmitButtonLocator;

	public LoginCRMPage() {
		PageFactory.initElements(driver, this);
	}

	public void LoginCRM() {

		ElementAction.SendKeys(UsernameLocator, getConfigProperty("UserName"));

		ElementAction.SendKeys(PasswordLocator, getConfigProperty("PassWord"));

		ClickSubmit();
	}

	private void ClickSubmit() {
		ElementAction.Click(SubmitButtonLocator);
	}

}
