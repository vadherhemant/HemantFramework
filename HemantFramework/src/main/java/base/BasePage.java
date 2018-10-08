package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import util.ProjProperties;

public class BasePage {

	public static WebDriver driver;

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

			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);

			driver.get(webURL);
		}
	}
}
