package com.selenium.hybridfw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listeners implements ITestListener {
	protected static ExtentReports reports;
	protected static ExtentTest test;

	/**
	 * Listener is defined as interface that modifes the default TestNG's
	 * behavior. As the name suggests Listeners "listen" to the event defined in
	 * the selenium script and behave accordingly. It is used in selenium by
	 * implementing Listeners Interface. It allows customizing TestNG reports or
	 * logs. There are many types of TestNG listeners available.
	 * 
	 * Types of Listeners
	 * http://testng.org/doc/documentation-main.html#testng-listeners These
	 * interfaces are used in selenium to generate logs or customize the Testing
	 * reports.
	 * 
	 * Step 1: Create class and implement ITestListener Step 2: Add
	 * unimplemented Methods Step 3: Implement Methods - OnSuccess etc., Step 4:
	 * Implement Listeners at class
	 */

	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :" + result.getName());
		String methodName = result.getName().toString().trim();
		String file = test
				.addScreenCapture("C:\\Users\\Hp\\Appium_Demo\\hybridfw\\screenshots\\" + methodName + ".png");
		try {
			WebDriverHelper.getscreenshot(methodName);

			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
					result.getThrowable().getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("The name of the testcase is :" + context.getName());
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	}

	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();

	}

}
