package com.wakatuts.driver;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static  WebDriver getDriver() {

        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {

        webDriver.set(driver);
    }
    
    public static void removeDriver() {
    	
    	webDriver.remove();
    }
    
    public static void openBrowser(String url) {
    	getDriver().get(url);
    }

}
