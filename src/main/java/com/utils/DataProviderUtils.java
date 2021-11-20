package com.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.constants.FrameworkConstants;

public final class DataProviderUtils {

	/*
	* It will handle test input data and running iterations.
	* Input data - 'testdata.xlsx' file 'DATA' sheet
	* Previous step : 'MethodInterceptor' listener will do this job.
	* 		           Check test case name and execute value from 'RUNMANAGER' sheet.
	* 			       - If execute 'yes', will run all this test case name in 'DATA' sheet
	* 			       - If execute 'no', will not run any this test case in 'DATA' sheet(even execute value 'yes' in execute column in 'DATA')
	* Step : 1. Check test case name in 'DATA' sheet
	*		 2. If test case name is same as the one that 'RUNMANAGER' execute value 'yes', will check 'execute' value in 'DATA' sheet.
	* 		 3. If 'execute' value is 'yes' in 'DATA', it will run the test(In this case, evenif there are several identical names, it will de executed all)
	* 		 4. If execute value in 'DATA' sheet is 'no', it will not running the test.
	*
	*'DATA' sheet in excel - if column don't have value just type single quotation mark(').
	* */


	private static List<Map<String, String>> list = new ArrayList<>();
	
	/* If set up for parallel=true, will provide test data parallel and run test parallel.
		TestNG.xml file control data provider thread count - will run 3 test case
			<suite name="All Test Suite" data-provider-thread-count="3">
	*/
	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}
		
		List<Map<String, String>> smalllist = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && 
					list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smalllist.add(list.get(i));
				}
			}
		return smalllist.toArray();	
	}
}
