package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjProperties {
	
	public static String getConfigProperty(String PropertyKey) {
		
		Properties prop = new Properties();
		
		try {
			FileInputStream configFile = new FileInputStream("resources/config/config.properties");
			prop.load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(PropertyKey);
	}
}
