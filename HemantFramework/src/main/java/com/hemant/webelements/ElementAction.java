package com.hemant.webelements;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.hemant.browserfactory.BasePage;

public class ElementAction extends BasePage {

	static WebDriverWait wait = new WebDriverWait(driver, 30);
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static Actions actions = new Actions(driver);

	
	
	public static final void Click(WebElement element) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

		} catch (Exception e0) {
			try {
				logConsoleMessage("Failed to perform element.click.  Trying to click using Keys.RETURN.");
				element.sendKeys(Keys.RETURN);

			} catch (Exception e1) {
				try {
					logConsoleMessage("Failed to perform Keys.RETURN.  Trying to click using js.executeScript(arguments[0].click(), element");
					js.executeScript("arguments[0].click();", element);

				} catch (Exception e2) {
					try {
						logConsoleMessage("Failed to perform click using js.executeScript(arguments[0].click(), element).  Trying to click using js.executeScript(document.getElementsByName(element.getTagName())[0].click()");
						js.executeScript("document.getElementsByName('" + element.getTagName() + "')[0].click()");

					} catch (Exception e3) {
						try {
							logConsoleMessage("Failed to perform click using js.executeScript(document.getElementsByName(element.getTagName())[0].click().  Trying to click using actions.click(element).perform()");
							actions.click(element).perform();

						} catch (Exception e4) {
							try {
								logConsoleMessage("Failed to perform click using actions.click(element).perform().  Trying to click using actions.moveToElement(element).click().perform()");
								actions.moveToElement(element).click().perform();

							} catch (Exception e5) {
								try {
									logConsoleMessage("Failed to perform click using actions.moveToElement(element).click().perform().  Trying to click using actions.sendKeys(element, Keys.RETURN).perform()");
									actions.sendKeys(element, Keys.RETURN).perform();

								} catch (Exception e6) {
									try {
										logConsoleMessage("Failed to perform click using actions.sendKeys(element, Keys.RETURN).perform().  Trying to click using actions.clickAndHold(element).release().perform()");
										actions.clickAndHold(element).release().perform();

									} catch (Exception e7) {
										logConsoleMessage("UNABLE TO PERFORM CLICK ON ELEMENT:-> " + element);
									}
								}
							}
						}
					}
				}
			}
		} finally {
			// logConsoleMessage(getDateTime() + " >>> CLICKED ON LINK:-> " + element);
		}
	}

	public static final void SendKeys(WebElement element, String textToEnter) {

		int i;
		char c;
		String s;

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.click();
			element.clear();

			for (i = 0; i < textToEnter.length(); i++) {
				c = textToEnter.charAt(i);
				s = new StringBuilder().append(c).toString();
				element.sendKeys(s);
				Thread.sleep(30);
			}

		} catch (Exception e) {
			logConsoleMessage("CANNOT ENTER TEXT ON ELEMENT:-> " + element);
		}
	}

}