package com.wakatuts.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.wakatuts.core.ExtentReportHandler;
import com.wakatuts.core.TestLogger;
import com.wakatuts.dataprovider.Constants;
import com.wakatuts.driver.Driver;

public class TestListener implements IInvokedMethodListener, ITestListener, IExecutionListener {
	
	@Override
	public void onExecutionStart() {
		ExtentReportHandler.setReports();
	}
	
	@Override
	public void onExecutionFinish() {
		ExtentReportHandler.getReports().flush();
	}
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if(method.isTestMethod()) {
			ExtentReportHandler.setTest(method.getTestMethod().getMethodName());
			TestLogger.setInfo("TEST NAME", method.getTestMethod().getMethodName());
			TestLogger.setInfo("TEST DESCRIPTION", method.getTestMethod().getDescription());
	        for (String group : method.getTestMethod().getGroups()) {
	        	ExtentReportHandler.getTest().assignCategory(group);
	        }
		}
	}
		
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			 takeScreenshotOnFailure(result);
			 TestLogger.setFail(result.getThrowable().getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExtentReportHandler.endTest();	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		TestLogger.setPass("Test Passed!");
	}
	
    public void takeScreenshotOnFailure(ITestResult testResult) throws IOException {
    	String fileName = testResult.getName() + "-"
                + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ".png";
        File screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File(Constants.SCREENSHOT_PATH + fileName);
        FileUtils.copyFile(screenShot, destination);
        ExtentReportHandler.setScreenshot(fileName);
    }

}
