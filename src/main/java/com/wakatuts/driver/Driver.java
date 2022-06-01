package com.wakatuts.driver;

import org.openqa.selenium.WebDriver;

public class Driver {

    WebDriver driver;

    public Driver(WebDriver driver) {
        this.driver = driver;
    }

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static  WebDriver getDriver() {

        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {

        webDriver.set(driver);
    }
    
    public static void removeDriver() {
    	
    	webDriver.remove();
    }

}
