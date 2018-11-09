package com.hemant.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericUtilities {

	public static void sleep(int sleepValue) throws InterruptedException {
		try {
			Thread.sleep(sleepValue);
		} catch (InterruptedException e) {
			logConsoleMessage("Error in sleep method.." + e.getMessage());
			Thread.currentThread().interrupt();

		}

	}

	public String currentDtTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");

		Date date = new Date();

		return dateFormat.format(date);
	}
	
	public static void logConsoleMessage(String message) {
		System.out.println(message);
	}
}
