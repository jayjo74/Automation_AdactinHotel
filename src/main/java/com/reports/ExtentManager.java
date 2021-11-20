package com.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
		
	}
	
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	static ExtentTest getExtentTest() { //default --> it can be only accessed within the package -->private package
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}
}
