package scratch;

import java.net.MalformedURLException;
/*import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;*/

public class TryingSeleniumGrid {
	
	public static void main(String[] args) throws MalformedURLException {
		
	/*	WebDriver drv;
		String baseURL, nodeURL;
		
		baseURL="https://www.freecrm.com/index.html";
		nodeURL="http://192.168.0.55:4444/wd/hub";
		
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN10);
		drv = new RemoteWebDriver(new URL(nodeURL), capability);
		
		drv.get(baseURL);
		Assert.assertEquals("", drv.getTitle());*/
		
		
		String s = new String("Test");
		
		s.concat("software");
		
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer("string");
		sb.append("buffer");
		
		System.out.println(sb);
		

	}

	
}
