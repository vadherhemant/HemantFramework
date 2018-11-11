package com.hemant.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.hemant.util.ElementHighlighter;
import com.hemant.util.GenericUtil;

public class WebEventListener implements WebDriverEventListener {
	
	public void beforeAlertAccept(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeAlertAccept");
	}

	public void afterAlertAccept(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterAlertAccept");
	}

	public void afterAlertDismiss(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterAlertDismiss");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeAlertDismiss");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeNavigateRefresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterNavigateRefresh");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//GenericUtil.logConsoleMessage("WebEventListener + beforeChangeValueOf");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//GenericUtil.logConsoleMessage("WebEventListener + afterChangeValueOf");
	}

	public void beforeScript(String script, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeScript");
	}

	public void afterScript(String script, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterScript");
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeSwitchToWindow");
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterSwitchToWindow");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		GenericUtil.logConsoleMessage("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Trying to click on: " + element.toString());
		//ElementHighlighter.highlightElement(driver, element);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		GenericUtil.logConsoleBlankMessage();
		GenericUtil.logConsoleMessage("++++++++++++++++++EXCEPTION OCCURED++++++++++++++++++");
		GenericUtil.logConsoleMessage("EXCEPTION IS: " + error);
		GenericUtil.logConsoleMessage("++++++++++++++++++END OF EXCEPTION++++++++++++++++++");
		GenericUtil.logConsoleBlankMessage();
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		//GenericUtil.logConsoleMessage("Trying to find Element By : " + by.toString());
		ElementHighlighter.highlightElement(element, driver);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		ElementHighlighter.highlightElement(element, driver);
	}
}
