package com.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.utils.DataProviderUtils;

public class AnnotaionTransformer implements IAnnotationTransformer{

	/*
	* All of test method will have same testNG annotation
	* EX)
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
    	public void Adactin_Login(Map<String, String> data){
	*
	* And at that kind case, create  'AnnotaionTransformer' listener and add it in testng.xml file
	* <listener class-name="com.listeners.AnnotaionTransformer" />
	*
	* */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}
