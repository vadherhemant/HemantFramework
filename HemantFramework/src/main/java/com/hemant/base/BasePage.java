package com.hemant.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hemant.generic.ProjProperties;
import com.hemant.generic.WebEventListener;
import com.hemant.util.GenericUtilities;

public class BasePage extends GenericUtilities {

	public static WebDriver driver;

	public BasePage() {

		try {

			if (driver == null) {

				startBrowser();
			}

		} catch (UnsupportedOperationException e1) {
			logConsoleMessage("No valid browser name match found to start...");
			e1.getMessage();

		} catch (Exception e) {
			logConsoleMessage("Error occurred while starting the browser driver ...");
			e.printStackTrace();
		}
	}

	public void stopBrowser() {

		try {
			if (driver != null) {
				logConsoleMessage("Stopping Driver...");
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			logConsoleMessage("Error occurred while stopping the browser driver...");
			e.printStackTrace();
		}

	}
	
/*	public String currentDtTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");

		Date date = new Date();

		return dateFormat.format(date);
	}*/
	
	
/*	public static void logConsoleMessage(String message) {
		System.out.println(message);
	}*/
	

	private void startBrowser() {

		setDriverToBrowser();

		setEventListener();

		setManageDriver();

		setBrowserZoom(100);

		loadWebsite();

	}

	
	private void setDriverToBrowser() {
		String browserName = ProjProperties.getConfigProperty("Browser");
		logConsoleMessage("Starting browser " + browserName + "...");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(ProjProperties.getConfigProperty("ChromeKeyProperty"),
					ProjProperties.getConfigProperty("WinChromeDriverPath"));
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(ProjProperties.getConfigProperty("FireFoxKeyProperty"),
					ProjProperties.getConfigProperty("WinFireFoxDriverPath"));
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty(ProjProperties.getConfigProperty("IEDriverKeyProperty"),
					ProjProperties.getConfigProperty("WinIEDriverPath"));
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty(ProjProperties.getConfigProperty("EdgeKeyProperty"),
					ProjProperties.getConfigProperty("WinEdgeDriverPath"));
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase(null)) {
			logConsoleMessage("Browser Name cannot be Null.");
			driver = null;
			throw new UnsupportedOperationException("Driver is Null, cannot test further");
		}
	}

	
	private void loadWebsite() {

		String webURL = ProjProperties.getConfigProperty("URL");

		try {
			logConsoleMessage("Loading the Website...");
			driver.get(webURL);

		} catch (Exception e) {
			logConsoleMessage("Error occurred while loading the website: " + webURL);
			e.printStackTrace();
		}

	}

	
	private void setBrowserZoom(int zoom) {
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='" + zoom + "%';");
	}

	
	private void setManageDriver() {
		long implicitWait = Long.parseLong(ProjProperties.getConfigProperty("ImplicitWait"));
		long pageWait = Long.parseLong(ProjProperties.getConfigProperty("PageWaitTime"));
		long scriptWait = Long.parseLong(ProjProperties.getConfigProperty("ScriptWaitTime"));

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
	}

	
	private void setEventListener() {

		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);

		WebEventListener eventListener = new WebEventListener();

		e_driver.register(eventListener);

		driver = e_driver;
	}



}
