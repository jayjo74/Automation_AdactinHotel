package com.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.constants.FrameworkConstants;
import com.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{

	/**
	*It will check Excel file(testdata) RUNMANAGER sheet and
	* 	- if testname match with test method will check 'execute' column value.
	*   - if 'execute' column is 'yes', will run the test.
	*
	* It will just control runing the test method or not.
	* */
	//List will contain all the test that testng going to execute
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String,String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) && 
						list.get(j).get("execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription((list.get(j).get("testdescription")));
						result.add(methods.get(i));
					}
				}
			}
		return result;
	}

}
