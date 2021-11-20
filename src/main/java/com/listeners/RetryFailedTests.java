package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int retries =1;
	
	/*
	* If test method failed, run one more time.
	* Step - 1. Check 'retryfailedtests' value from config.properties file
	* 		 2. if 'yes' and test case failed, will run one more time.
	* 		 3. At that kind case, first trial will be display 'Skip' in Extent report.
	* */

	@Override
	public boolean retry(ITestResult result) {
		
		boolean value = false;
		
		/* Check 'retryfailedtests' value first in config.properties
		   And if it is 'yes', test will re-try the failed test method.
		 */
		if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = count<retries;
				count++;
			}

		return value;
	}

}
