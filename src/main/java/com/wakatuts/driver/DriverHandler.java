package com.wakatuts.driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.wakatuts.dataprovider.ConfigReader;
import com.wakatuts.dataprovider.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHandler {
	
	private static WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
 
	public static WebDriver createInstance() {
		
		String autoEnv = ConfigReader.getStringProperty("autoEnv");
		
		WebDriver driver = null;
		
		switch (autoEnv.toUpperCase()) {
		case "LOCAL":
			driver = createDriver();
			break;
		case "REMOTE":
			driver = createDriver();
			break;
		default:
			break;
		}
		return driver;
	}
	
	private static WebDriver createDriver() {
		String driverType = ConfigReader.getStringProperty("browser");
		switch (driverType.toUpperCase()) {
		case "FIREFOX": 
			driver = new FirefoxDriver();
			break;
		case "CHROME":
			WebDriverManager.chromedriver().setup();
//			System.setProperty(CHROME_DRIVER_PROPERTY, ConfigReader.getStringProperty("driverPath"));
			Map<String, Object> chromePrefs = new HashMap<>();
			String downloadPath =  System.getProperty("os.name").startsWith("Windows") ? 
					Constants.DOWNLOAD_FILE_PATH : Constants.DOWNLOAD_FILE_PATH.replace("\\", "/");
			chromePrefs.put("download.default_directory", downloadPath);
			chromePrefs.put("profile.default_content_settings_popups", 0);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			chromeOptions.addArguments("mute-audio");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("disable-infobars");
//			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("--proxy-server='direct://'");
			chromeOptions.addArguments("--proxy-bypass-list=*");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--disable-notifications");
			
			if(ConfigReader.getBooleanProperty("isHeadless")) {
				chromeOptions.addArguments("--headless");
				chromeOptions.setHeadless(true);
			}

			if (ConfigReader.getBooleanProperty("isWindowMaximize")) {
				chromeOptions.addArguments("--window-size=1920x1080");
				chromeOptions.addArguments("--start-maximized");
			}
			
			driver = new ChromeDriver(chromeOptions);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_TIMEOUT));
			driver.manage().window().maximize();
			break;
		case "EDGE": 
			driver = new EdgeDriver();
			break;
		}
		
		return driver;
		
	}

}
