package com.hemant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hemant.browserfactory.BasePage;
import com.hemant.webelements.ElementAction;

public class LoginCRMPage extends BasePage {

	@CacheLookup
	@FindBy(how = How.NAME, using = "username")
	WebElement userName;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement passWord;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	WebElement submitButton;

	public LoginCRMPage() {
		PageFactory.initElements(driver, this);
	}

	public void LoginCRM() {

		ElementAction.SendKeys(userName, getConfigProperty("UserName"));

		ElementAction.SendKeys(passWord, getConfigProperty("PassWord"));

		ClickSubmit();
	}

	public void LoginCRM(String username, String password) {
		ElementAction.SendKeys(userName, username);
		ElementAction.SendKeys(passWord, password);
		ClickSubmit();
	}

	private void ClickSubmit() {
		ElementAction.Click(submitButton);
	}

}
