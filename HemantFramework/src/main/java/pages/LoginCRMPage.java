package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.ElementAction;
import util.ProjProperties;

public class LoginCRMPage extends BasePage{
	
	@FindBy (how = How.NAME, using="username")
	WebElement userName;
	
	@FindBy(how = How.NAME, using="password")
	WebElement passWord;
	
	@FindBy(how = How.XPATH, using="//input[@type='submit']")
	WebElement submitButton;
	
	public LoginCRMPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void LoginCRM() {
		
		ElementAction.SendKeys(userName, ProjProperties.getConfigProperty("Username"));
		
		ElementAction.SendKeys(passWord, ProjProperties.getConfigProperty("Password"));
		
		ElementAction.ClickOnButton(submitButton);
	}

}
