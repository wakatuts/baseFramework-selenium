package com.wakatuts.element.handler;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wakatuts.dataprovider.Constants;
import com.wakatuts.driver.Driver;

import io.netty.util.Constant;

public class ElementHandler {
	
	public static WebElement findElement(By by) {
		return findElement(by, Constants.LONG_TIMEOUT);
	}
	
	public static WebElement findElement(By by, int timeout) {
		WebElement element = null;
		try {
			element = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofMillis(Constants.POLLING_INTERVAL))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			element = null;
		}
		if(element != null) {
			try {
				Actions actions = new Actions(Driver.getDriver());
				actions.moveToElement(element);
				actions.perform();
			} catch (Exception e) {
				//TODO add info log step
			}
		}
		return element;
	}
	
	public static List<WebElement> findElements(By by) {
		List<WebElement> elements = null;
		try {
			elements = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Constants.LONG_TIMEOUT))
					.pollingEvery(Duration.ofMillis(Constants.POLLING_INTERVAL))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		} catch (Exception e) {
			elements = null;
		}
		if(elements != null) {
			try {
				Actions actions = new Actions(Driver.getDriver());
				actions.moveToElement(elements.get(0));
				actions.perform();
			} catch (Exception e) {
				//TODO add info log step
			}
		}
		return elements;
	}
	
	private static ExpectedCondition<Boolean> presenceOfElementNotLocated(By by){
	    return new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	        	WebElement element = null;
	        	try {
	        		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.SHORT_TIMEOUT));
	        		element = driver.findElement(by);
				} catch (Exception e) {
					element = null;
				} finally {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_TIMEOUT));
				}
	          return element == null ? true : false;
	        }

	        @Override
	        public String toString() {
	          return "presence of element not located by: " + by;
	        }
	      };
	}
	
	public static boolean waitElementNotPresent(By by, int timeout) {
		return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(Constants.POLLING_INTERVAL))
				.until(presenceOfElementNotLocated(by));
	}
}
