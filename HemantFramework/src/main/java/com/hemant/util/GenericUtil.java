package com.hemant.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GenericUtil {

	public static void waitForSeconds(final int seconds) {
		try {
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {
			logConsoleMessage("Error in sleep method.." + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}
	
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
	
	public static void logConsoleBlankMessage() {
		System.out.println("");
	}

	public static void logConsoleMessage(String message) {
		System.out.println(getDateTime() + " >>> " + message);
	}

	public static String getDateTime() {
		
		DateFormat dateFormat;
		Date date;
		
		dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");

		date = new Date();

		return dateFormat.format(date);
	}
}
