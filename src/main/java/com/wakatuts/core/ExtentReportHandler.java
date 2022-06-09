package com.wakatuts.core;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.wakatuts.dataprovider.Constants;

public class ExtentReportHandler {

	private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	private static ExtentReports extentReports;
	private static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentTest getTest() {
		return extentTestThread.get();
	}
	
	public static void setTest(String testName) {
		extentTestThread.set(extentReports.createTest(testName));
	}
	
	public static void setReports() {
		extentSparkReporter = new ExtentSparkReporter(Constants.EXTENT_REPORT_PATH);
		extentSparkReporter.config().setDocumentTitle("Regression Results");
		extentSparkReporter.config().setReportName("Regression Results");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setTimelineEnabled(true);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Test Type", "Regression Testing");	
		extentReports.setReportUsesManualConfiguration(true);
	}
	
	public static ExtentReports getReports() {
		return extentReports;
	}
	
	public static void setScreenshot(String fileName) throws IOException {
		getTest().addScreenCaptureFromPath(Constants.EXTENT_REPORT_PATH + fileName);
	}

}
