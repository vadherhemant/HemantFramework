package com.hemant.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.hemant.base.BasePage;
import com.hemant.util.DateUtil;
import com.hemant.util.ElementHighlighter;

public class WebEventListener extends BasePage implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + beforeAlertAccept");
	}

	public void afterAlertAccept(WebDriver driver) {
		
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + afterAlertAccept");
	}

	public void afterAlertDismiss(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + afterAlertDismiss");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + beforeAlertDismiss");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + beforeNavigateRefresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + afterNavigateRefresh");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//ElementHighlighter.highlightElement(driver, element);
		//logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + beforeChangeValueOf");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + afterChangeValueOf");
	}

	public void beforeScript(String script, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + beforeScript");
	}

	public void afterScript(String script, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + afterScript");
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + beforeSwitchToWindow");
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> WebEventListener + afterSwitchToWindow");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//ElementHighlighter.highlightElement(driver, element);
		logConsoleMessage(DateUtil.getDateTime() + " >>> Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		logConsoleMessage("^^^^^^^^^^^^^^^^^^");
		logConsoleMessage("^^^^^^^^^^^^^^^^^^");
		logConsoleMessage(DateUtil.getDateTime() + " >>> EXCEPTION OCCURED: " + error);
		logConsoleMessage("++++++++++++++++++");
		logConsoleMessage("++++++++++++++++++");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logConsoleMessage(DateUtil.getDateTime() + " >>> Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		ElementHighlighter.highlightElement(driver, element);
		
		logConsoleMessage(DateUtil.getDateTime() + " >>> Found Element By : " + by.toString());
	}

}
