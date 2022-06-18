package com.wakatuts.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.wakatuts.core.TestLogger;
import com.wakatuts.driver.Driver;
import com.wakatuts.driver.DriverHandler;
import com.wakatuts.listener.ExtentReportListener;
import com.wakatuts.listener.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
	
	@BeforeMethod
	public void initializeBrowser() {
		Driver.setWebDriver(DriverHandler.createInstance());
	}

	@AfterMethod
	public void tearDownBrowser() {
		Driver.getDriver().quit();
		Driver.removeDriver();
	}
}
