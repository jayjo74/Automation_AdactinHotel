package com.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	/**
	 * Nobody can extend this class - secure code
	 * Nobody can create this object outside of this class
	 */

	private DriverManager() {
		
	}
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverref) {
		driver.set(driverref);
	}

	public static void unload() {
		driver.remove();
	}
}
