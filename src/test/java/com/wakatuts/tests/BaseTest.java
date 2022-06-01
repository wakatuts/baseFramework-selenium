package com.wakatuts.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.wakatuts.driver.Driver;
import com.wakatuts.driver.DriverHandler;

public class BaseTest {
	
	protected static void openBrowser(String url) {
		Driver.getDriver().get(url);
	}
	
	@BeforeMethod
	public static void initializeBrowser() {
		Driver.setWebDriver(DriverHandler.createInstance());
	}
	
	@AfterMethod
	public static void closeBrowser() {
		Driver.getDriver().close();
	}

}
