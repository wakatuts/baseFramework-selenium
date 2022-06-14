package com.wakatuts.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;

import com.wakatuts.core.ExtentReportHandler;
import com.wakatuts.core.TestLogger;
import com.wakatuts.dataprovider.Constants;
import com.wakatuts.driver.Driver;

public class TestListener implements IInvokedMethodListener, ISuiteListener {

	private ThreadLocal<ITestResult> testResultThread = new ThreadLocal<ITestResult>();
	
	@Override
	public void onStart(ISuite suite) {
		ExtentReportHandler.setReports();
	}
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		if(method.isTestMethod()) {
			ExtentReportHandler.setTest(method.getTestMethod().getMethodName());
			TestLogger.setInfo("TEST NAME", method.getTestMethod().getMethodName());
			TestLogger.setInfo("TEST DESCRIPTION", method.getTestMethod().getDescription());
		}
	}
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if(method.isTestMethod()) {
			if(Driver.getDriver() != null) {
				try {
					takeScreenshotOnFailure(testResult);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Closing webdriver session: " + Thread.currentThread().getId());
				Driver.getDriver().quit();
				ExtentReportHandler.getTest().getModel().setEndTime(Calendar.getInstance().getTime());
				Driver.removeDriver();
			}
		}
	}
	
    private ITestResult getTestResult() {
    	return this.testResultThread.get();
    }
    
    public void takeScreenshotOnFailure(ITestResult testResult) throws IOException {

        if(testResult.getStatus() == ITestResult.FAILURE || testResult.getStatus() == ITestResult.SKIP) {
        	
        	String fileName = testResult.getName() + "-"
                    + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ".png";

            File screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            File destination = new File(Constants.SCREENSHOT_PATH + fileName);
            FileUtils.copyFile(screenShot, destination);
            
            ExtentReportHandler.setScreenshot(fileName);
        }
    }

}
