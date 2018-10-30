package com.hemant.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.hemant.base.BasePage;

public class WebEventListener extends BasePage implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("WebEventListener + beforeAlertAccept");

	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("WebEventListener + afterAlertAccept");

	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("WebEventListener + afterAlertDismiss");

	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("WebEventListener + beforeAlertDismiss");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("WebEventListener + beforeNavigateRefresh");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("WebEventListener + afterNavigateRefresh");

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//System.out.println("WebEventListener + beforeChangeValueOf");

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		//System.out.println("WebEventListener + afterChangeValueOf");

	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("WebEventListener + beforeScript");

	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("WebEventListener + afterScript");

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("WebEventListener + beforeSwitchToWindow");

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("WebEventListener + afterSwitchToWindow");

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("++++++++++++++++++");
		System.out.println("++++++++++++++++++");
		System.out.println("EXCEPTION OCCURED: " + error);
		System.out.println("++++++++++++++++++");
		System.out.println("++++++++++++++++++");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

}
