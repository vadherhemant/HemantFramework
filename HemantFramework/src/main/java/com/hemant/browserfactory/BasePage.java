package com.hemant.browserfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hemant.reporter.WebEventListener;
import com.hemant.util.GenericUtil;

public class BasePage extends GenericUtil {

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

	public final void stopBrowser() {

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

	private final void startBrowser() {

		setDriverToBrowser();

		setEventListener();

		setManageDriver();

		setBrowserZoom(100);

		loadWebsite();
	}

	private void setDriverToBrowser() {
		String browserName = getConfigProperty("Browser");
		logConsoleMessage("Starting browser " + browserName + "...");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(getConfigProperty("ChromeKeyProperty"), getConfigProperty("WinChromeDriverPath"));
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(getConfigProperty("FireFoxKeyProperty"), getConfigProperty("WinFireFoxDriverPath"));
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			
			
			System.setProperty(getConfigProperty("IEDriverKeyProperty"), getConfigProperty("WinIEDriverPath"));
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty(getConfigProperty("EdgeKeyProperty"), getConfigProperty("WinEdgeDriverPath"));
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase(null)) {
			logConsoleMessage("Browser Name cannot be Null.");
			driver = null;
			throw new UnsupportedOperationException("Driver is Null, cannot test further");
		}
	}

	private final void loadWebsite() {

		String webURL = getConfigProperty("URL");

		try {
			logConsoleMessage("Loading the Website... " + webURL);
			driver.get(webURL);
			GenericUtil.waitForSeconds(2);

		} catch (Exception e) {
			logConsoleMessage("Error occurred while loading the website: " + webURL);
			e.printStackTrace();
		}
	}

	private final void setBrowserZoom(int zoom) {
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='" + zoom + "%';");
	}

	private void setManageDriver() {
		long implicitWait = Long.parseLong(getConfigProperty("ImplicitWait"));
		long pageWait = Long.parseLong(getConfigProperty("PageWaitTime"));
		long scriptWait = Long.parseLong(getConfigProperty("ScriptWaitTime"));

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(scriptWait, TimeUnit.SECONDS);
	}

	private final void setEventListener() {

		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);

		WebEventListener eventListener = new WebEventListener();

		e_driver.register(eventListener);

		driver = e_driver;
	}
	
	public static final void switchToFrameMainPanel() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static final void switchToFrameDefault() {
		driver.switchTo().defaultContent();
	}
}
