package com.wakatuts.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.wakatuts.driver.Driver;
import com.wakatuts.driver.DriverHandler;
import com.wakatuts.listener.ExtentReportListener;
import com.wakatuts.listener.TestListener;

@Listeners({TestListener.class, ExtentReportListener.class})
public class BaseTest {
	
	protected static void openBrowser(String url) {
		Driver.getDriver().get(url);
	}
	
	@BeforeMethod
	public static void initializeBrowser() {
		Driver.setWebDriver(DriverHandler.createInstance());
	}

}
