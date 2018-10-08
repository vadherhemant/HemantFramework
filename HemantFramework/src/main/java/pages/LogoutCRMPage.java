package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.ElementAction;

public class LogoutCRMPage extends BasePage {

	@FindBy(how = How.XPATH, using="//a[contains(@href,'logout')]")
	WebElement logoutLink;
	
	public LogoutCRMPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void LogoutCRM() {
		driver.switchTo().frame("mainpanel");
		ElementAction.ClickOnLink(logoutLink);
		driver.switchTo().parentFrame();
	}
	
}
