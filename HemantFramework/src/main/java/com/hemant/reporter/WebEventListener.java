package com.hemant.reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.hemant.util.ElementHighlighter;
import com.hemant.util.GenericUtil;

public class WebEventListener implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeAlertAccept");
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterAlertAccept");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterAlertDismiss");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeAlertDismiss");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeNavigateRefresh");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterNavigateRefresh");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// GenericUtil.logConsoleMessage("WebEventListener + beforeChangeValueOf");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// GenericUtil.logConsoleMessage("WebEventListener + afterChangeValueOf");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeScript");
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterScript");
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + beforeSwitchToWindow");
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		GenericUtil.logConsoleMessage("WebEventListener + afterSwitchToWindow");
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		GenericUtil.logConsoleMessage("Before navigating to: '" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Element value changed to: " + element.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Trying to click on: " + element);

		ElementHighlighter.highlightElement(element, driver);
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		GenericUtil.logConsoleMessage("Clicked on: " + element.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigating back to previous page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigated back to previous page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigating forward to next page");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		GenericUtil.logConsoleMessage("Navigated forward to next page");
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		GenericUtil.logConsoleBlankMessage();
		GenericUtil.logConsoleMessage("++++++++++++++++++EXCEPTION OCCURED++++++++++++++++++");
		GenericUtil.logConsoleMessage("EXCEPTION IS: " + error);
		GenericUtil.logConsoleMessage("++++++++++++++++++END OF EXCEPTION++++++++++++++++++");
		GenericUtil.logConsoleBlankMessage();
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		/*
		 * GenericUtil.logConsoleMessage("BEFORE FindBy CHECK VALUE OF ELEMENT" +
		 * element);
		 * GenericUtil.logConsoleMessage("BEFORE FindBy CHECK VALUE OF by is: " + by);
		 */
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		/*
		 * GenericUtil.logConsoleMessage("AFTERFindBy CHECK VALUE OF ELEMENT" +
		 * element); GenericUtil.logConsoleMessage("AFTERFindBy CHECK VALUE OF by is: "
		 * + by);
		 */ // ElementHighlighter.highlightElement(element, driver);
	}
}
