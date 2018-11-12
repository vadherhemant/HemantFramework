package com.hemant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hemant.browserfactory.BasePage;
import com.hemant.webelements.ElementAction;

public class LogoutCRMPage extends BasePage {

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'logout')]")
	WebElement logoutLink;

	public LogoutCRMPage() {
		PageFactory.initElements(driver, this);
	}

	public void LogoutCRM() {

		try {
			driver.switchTo().frame("mainpanel");

			ElementAction.Click(logoutLink);

		} finally {
			driver.switchTo().parentFrame();
		}

	}

}
