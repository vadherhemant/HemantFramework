package com.hemant.listeners;

import com.hemant.base.BasePage;
import com.hemant.extentreports.ExtentManager;
import com.hemant.extentreports.ExtentTestManager;
import com.hemant.util.DateUtil;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener extends BasePage implements ITestListener{

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
        //iTestContext.getStartDate()
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed." + iTestResult.getThrowable());

        //Get driver from BaseTest and assign to local webdriver variable.
        //Object testClass = iTestResult.getInstance();
        //WebDriver webDriver = ((BasePage) testClass).getDriver();

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
                getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, DateUtil.getDateTime() + "   Test Failed. " + iTestResult.getThrowable(),
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, DateUtil.getDateTime()  + "   Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logConsoleMessage(DateUtil.getDateTime() + " >>>  Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
