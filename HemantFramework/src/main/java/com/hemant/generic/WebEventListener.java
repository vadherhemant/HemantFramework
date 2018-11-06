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
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + beforeAlertAccept");
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + afterAlertAccept");
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + afterAlertDismiss");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + beforeAlertDismiss");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + beforeNavigateRefresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + afterNavigateRefresh");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//ElementHighlighter.highlightElement(driver, element);
		//System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + beforeChangeValueOf");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + afterChangeValueOf");
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + beforeScript");
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + afterScript");
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + beforeSwitchToWindow");
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> WebEventListener + afterSwitchToWindow");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//ElementHighlighter.highlightElement(driver, element);
		System.out.println(DateUtil.getDateTime() + " >>> Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("^^^^^^^^^^^^^^^^^^");
		System.out.println("^^^^^^^^^^^^^^^^^^");
		System.out.println(DateUtil.getDateTime() + " >>> EXCEPTION OCCURED: " + error);
		System.out.println("++++++++++++++++++");
		System.out.println("++++++++++++++++++");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(DateUtil.getDateTime() + " >>> Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		ElementHighlighter.highlightElement(driver, element);
		
		System.out.println(DateUtil.getDateTime() + " >>> Found Element By : " + by.toString());
	}

}
