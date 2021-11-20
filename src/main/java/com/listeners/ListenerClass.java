package com.listeners;

import com.annotations.FrameworkAnnotation;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	public void onStart(ISuite suite) {

			ExtentReport.initReports();
	}

	public void onFinish(ISuite suite) {

			ExtentReport.flushReports();
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed.");
	}

	public void onTestFailure(ITestResult result) {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed.", true);
			//Attach first line of error message in Extent Report
			ExtentLogger.fail(result.getThrowable().toString());
			//Attach whole error detail in Extent Report
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skiped.");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/* 
		 * For now, we are not using this
		 */
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		/* 
		 * For now, we are not using this
		 */
	}

	public void onStart(ITestContext context) {
		/* 
		 * We are having just one test in our suite. So we don't have any special implementation as of now
		 */
	}

	public void onFinish(ITestContext context) {
		/* 
		 * We are having just one test in our suite. So we don't have any special implementation as of now
		 */
	}


}
