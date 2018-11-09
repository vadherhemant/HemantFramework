package com.hemant.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hemant.base.BasePage;

public class ElementHighlighter {

	static JavascriptExecutor js; 
	
	public static void highlightElement(WebDriver driver, WebElement element) {
		
		highlightField(driver, element);
		
		waitFor(500);
		
		unHighlightField(driver, element);

	}

	private static void unHighlightField(WebDriver driver, WebElement element) {

		try {
			js.executeScript("arguments[0].setAttribute('style', 'background: border: 2px solid white;');", element);
			
		} catch (Exception e) {
			BasePage.logConsoleMessage("Exception occurred while UnHighlighting web element " + element);
			e.printStackTrace();
		}

		
	}

	private static void waitFor(int i) {
		try {
			Thread.sleep(500);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private static void highlightField(WebDriver driver, WebElement element) {
		
		js = (JavascriptExecutor)driver;
		
		try {
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		} catch (Exception e) {
			BasePage.logConsoleMessage("Exception occurred while Highlighting web element " + element);
			e.printStackTrace();
		}
			
	}
	
	
}
