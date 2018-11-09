package com.hemant.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hemant.util.DateUtil;

public class ElementAction extends BasePage {

	static WebDriverWait wait = new WebDriverWait(driver, 30);
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static Actions actions = new Actions(driver);
	
	public static void Click(WebElement element) {
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e0) {
			try {
				element.sendKeys(Keys.RETURN);
			} catch (Exception e1) {
				try {
					js.executeScript("arguments[0].click();", element);
				} catch (Exception e2) {
					try {
						js.executeScript("document.getElementsByName('" + element.getTagName() + "')[0].click()");
					} catch (Exception e3) {
						try {
							actions.click(element).perform();
						} catch (Exception e4) {
							try {
								actions.moveToElement(element).click().perform();
							} catch (Exception e5) {
								try {
									actions.sendKeys(element, Keys.RETURN).perform();
								} catch (Exception e6) {
									try {
										actions.clickAndHold(element).release().perform();
									} catch (Exception e7) {
										logConsoleMessage(DateUtil.getDateTime() + " >>> UNABLE TO PERFORM CLICK ON ELEMENT:-> " + element);
									}
								}
							}
						}
					}
				}
			}
		} /*finally {
			logConsoleMessage(DateUtil.getDateTime() + " >>> CLICKED ON LINK:-> " + element);
		}*/
	}

	public static void SendKeys(WebElement element, String text) {
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			element.clear();
			
			//element.sendKeys(text);
			int i;
			char c;
			String s;
			
			for (i=0; i< text.length(); i++) {
				c=text.charAt(i);
				s = new StringBuilder().append(c).toString();
				element.sendKeys(s);
				Thread.sleep(30);
			}
			
		} catch (Exception e) {
			logConsoleMessage(DateUtil.getDateTime() + " >>> CANNOT ENTER TEXT ON ELEMENT:-> " + element);
		}
	}
	
}
