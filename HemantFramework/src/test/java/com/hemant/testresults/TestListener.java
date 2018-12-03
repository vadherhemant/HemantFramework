package com.hemant.testresults;

import com.hemant.browserfactory.BasePage;
import com.hemant.extentreports.ExtentManager;
import com.hemant.extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BasePage implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		logConsoleMessage("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", driver);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		logConsoleMessage("I am in onFinish method " + iTestContext.getName());
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		logConsoleMessage("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		logConsoleMessage("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		logConsoleMessage("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed."
				+ iTestResult.getThrowable());

		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		ExtentTestManager.getTest().log(LogStatus.FAIL, getDateTime() + "   Test Failed. " + iTestResult.getThrowable(),
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		logConsoleMessage("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		ExtentTestManager.getTest().log(LogStatus.SKIP, getDateTime() + "   Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		logConsoleMessage("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	

}
