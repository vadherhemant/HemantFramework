package com.hemant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hemant.base.BasePage;
import com.hemant.base.ElementAction;
import com.hemant.generic.ProjProperties;

public class LoginCRMPage extends BasePage{
	
	@CacheLookup
	@FindBy (how = How.NAME, using="username")
	WebElement userName;
	
	@CacheLookup
	@FindBy(how = How.NAME, using="password")
	WebElement passWord;

	@CacheLookup
	@FindBy(how = How.XPATH, using="//input[@type='submit']")
	WebElement submitButton;
	
	public LoginCRMPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void LoginCRM() {
		
		ElementAction.SendKeys(userName, ProjProperties.getConfigProperty("Username"));
		
		ElementAction.SendKeys(passWord, ProjProperties.getConfigProperty("Password"));
		
		ElementAction.Click(submitButton);
	}

}
