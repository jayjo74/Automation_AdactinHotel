package com.tests;


import com.driver.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    protected BaseTest(){}

    /**
    * When we want to handle browser from config.properties, use this one
    */
//    @BeforeMethod
//    protected void setUp(Method m) throws Exception {
//        Driver.initDriver(PropertyUtils.get(ConfigProperties.BROWSER));
//    }

    /**
     * When we want to handle browser from Excel file in 'DATA' sheet, use this one
     */
    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data){
        Map<String, String> map = (Map<String, String>)data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown(ITestResult result){
        Driver.quitDriver();
    }

}
