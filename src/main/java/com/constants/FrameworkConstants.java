package com.constants;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

public final class FrameworkConstants {


	//Will keep using it and nobody will change it so use static final
	//Limited access, so use private

	private static final String RESOURCEPATH = System.getProperty("user.dir")+ "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH+ "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCEPATH+ "/executables/geckodriver.exe";

	private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
	private static final String JSONCONFIGPATH = RESOURCEPATH + "/config/config.json";
	private static final String EXCELPATH = RESOURCEPATH + "/excel/testdata.xlsx";
	private static final int EXPLICITWAIT = 10;
	private static final String EXTENTREPORTFOLDPATH = System.getProperty("user.dir")+ "/extent-test-output/";

	private static final String RUNMANAGERSHEET = "RUNMANAGER";

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	//Excel data sheet for handling test iteration 
	private static final String ITERATIONDATASHEET = "DATA";
	private static String extentReportFilePath = "";


	public static String getExtentReportFilePath(){
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath(){
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			/*
			* The java.lang.System.currentTimeMillis() method returns the current time in milliseconds
			* Current Time in milliseconds = 1349333576093
			* */
			return EXTENTREPORTFOLDPATH + System.currentTimeMillis()+ "_index.html";
		} else {
			return EXTENTREPORTFOLDPATH +"index.html";
		}

	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	//Do not get variable value directly, use get-method for this value 
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	public static String getJsonConfigPath() {
		return JSONCONFIGPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}





}
