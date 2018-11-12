package com.hemant.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	static ExtentReports extent = ExtentManager.getReporter();

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.endTest(extentTestMap.get((int) (Thread.currentThread().getId())));
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {

		ExtentTest test = extent.startTest(testName, desc);

		extentTestMap.put((int) (Thread.currentThread().getId()), test);

		return test;
	}
}
