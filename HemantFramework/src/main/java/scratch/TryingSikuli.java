package scratch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TryingSikuli {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "resources/drivers/win/chromedriver.exe");
		
		WebDriver driver1 = new ChromeDriver();
		
		driver1.get("https://www.freecrm.com/index.html");
		
		Pattern p = new Pattern("/resources/sikuli/images/login/usersname.PNG");
		
		Screen s = new Screen();
		
		try {
			s.click(p);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
		s.highlight();
		
	}

}
