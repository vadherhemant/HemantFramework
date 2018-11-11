package com.hemant.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hemant.base.BasePage;

public class ElementHighlighter {

	public static void highlightElement(WebElement ele, WebDriver drv) {

		highlightField(drv, ele);

		GenericUtil.sleep(2000);

		unHighlightField(drv, ele);
	}

	private static void unHighlightField(WebDriver Drv, WebElement Ele) {
		JavascriptExecutor js;

		try {
			js = (JavascriptExecutor)Drv;
			js.executeScript("arguments[0].setAttribute('style', 'background: border: 2px solid white;');", Ele);

		} catch (Exception e) {
			BasePage.logConsoleMessage("Exception occurred while UnHighlighting web element " + Ele);
			e.printStackTrace();
		}
	}

	private static void highlightField(WebDriver drV, WebElement elE) {
		JavascriptExecutor js;

		try {
			js = (JavascriptExecutor) drV;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					elE);

		} catch (Exception e) {
			BasePage.logConsoleMessage("Exception occurred while Highlighting web element " + elE);
			e.printStackTrace();
		}
	}
}
