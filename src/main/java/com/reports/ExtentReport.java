package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;
import com.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReports(){
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("AdactinHotel Test Report");
            spark.config().setReportName("Automation Test Report");
        }
    }

    public static void createTest(String testcasename){
        ExtentTest test = extent.createTest(testcasename);
        ExtentManager.setExtentTest(test);
    }

    public static void flushReports(){
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        //After test, Extent report will be automatically display in default web browser.
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAuthors(String[] authors){
        for(String temp:authors){
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for(CategoryType temp:categories){
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }
}
