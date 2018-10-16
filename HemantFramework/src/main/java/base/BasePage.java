package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.ProjProperties;
import util.WebEventListener;

public class BasePage {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;

	public BasePage() {

		if (driver == null) {
			String browserName = ProjProperties.getConfigProperty("Browser");
			String webURL = ProjProperties.getConfigProperty("URL");
			long implicitWait = Long.parseLong(ProjProperties.getConfigProperty("ImplicitWait"));
			long pageWait = Long.parseLong(ProjProperties.getConfigProperty("PageWaitTime"));

			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty(ProjProperties.getConfigProperty("ChromeKeyProperty"),
						ProjProperties.getConfigProperty("ChromeDriverPath"));
				driver = new ChromeDriver();
			
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty(ProjProperties.getConfigProperty("FireFoxKeyProperty"),
						ProjProperties.getConfigProperty("FireFoxDriverPath"));
				driver = new FirefoxDriver();
			
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty(ProjProperties.getConfigProperty("IEDriverKeyProperty"),
						ProjProperties.getConfigProperty("IEDriverPath"));
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty(ProjProperties.getConfigProperty("EdgeKeyProperty"),
						ProjProperties.getConfigProperty("EdgeDriverPath"));
				driver = new EdgeDriver();
				
				
				
			} else if (browserName.equalsIgnoreCase(null)) {
				System.out.println("Browser Name cannot be Null.");
				driver = null;
			}

			e_driver = new EventFiringWebDriver(driver);
			WebEventListener eventListener = new WebEventListener();
			e_driver.register(eventListener);
			
			driver = e_driver;
			
			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);

			((JavascriptExecutor)driver).executeScript("document.body.style.zoom='150%';");	
			
			driver.get(webURL);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
