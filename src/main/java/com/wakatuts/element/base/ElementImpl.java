package com.wakatuts.element.base;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;

import com.wakatuts.dataprovider.Constants;
import com.wakatuts.driver.Driver;
import com.wakatuts.element.handler.ElementHandler;

public class ElementImpl implements Element {

	public static ThreadLocal<WebElement> element = new ThreadLocal<WebElement>();
	private final WebElement localElement;
	private final By by;
	private final String elementName;
	
	public ElementImpl(By by, String elementName) {
		this.by = by;
		this.elementName = elementName; 
		this.localElement = null;
	}
	
	public ElementImpl(WebElement localElement, String elementName) {
		this.localElement = localElement;
		this.elementName = elementName;   
		this.by = null;
	}
	
	public void initiateElement() {
		if(this.localElement == null) {
			element.set(ElementHandler.findElement(by));
		} else if(this.by == null) {
			element.set(localElement);
		}
		if(element.get() == null) {
			Assert.fail(elementName + " is not present");
		}
	}
	
	@Override
	public void click() {
		initiateElement();
		element.get().click();
	}

	@Override
	public void submit() {
		initiateElement();
		element.get().submit();
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		initiateElement();
		element.get().sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		initiateElement();
		element.get().clear();
		
	}

	@Override
	public String getTagName() {
		initiateElement();
		return element.get().getTagName();
	}

	@Override
	public String getAttribute(String name) {
		initiateElement();
		return element.get().getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		initiateElement();
		return element.get().isSelected();
	}

	@Override
	public boolean isEnabled() {
		initiateElement();
		return element.get().isEnabled();
	}

	@Override
	public String getText() {
		initiateElement();
		return element.get().getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		initiateElement();
		return element.get().findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		initiateElement();
		return element.get().findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		initiateElement();
		return element.get().isDisplayed();
	}

	@Override
	public Point getLocation() {
		initiateElement();
		return element.get().getLocation();
	}

	@Override
	public Dimension getSize() {
		initiateElement();
		return element.get().getSize();
	}

	@Override
	public Rectangle getRect() {
		initiateElement();
		return element.get().getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		initiateElement();
		return element.get().getCssValue(propertyName);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		throw new UnsupportedOperationException("getScreenshotAs() not yet implemented");
	}

	@Override
	public WebElement getWrappedElement() {
		initiateElement();
		return element.get();
	}

	@Override
	public Coordinates getCoordinates() {
		initiateElement();
		return ((Locatable) element.get()).getCoordinates();
	}

	@Override
	public boolean elementWired() {
		element.set(ElementHandler.findElement(by));
		if(element.get() == null) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.elementName;
	}
	
	@Override
	public boolean isPresent(int timeout) {
		element.set(ElementHandler.findElement(by, timeout));
		if(element.get() == null) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean isPresent() {
		return isPresent(Constants.SHORT_TIMEOUT);
	}

	@Override
	public void forceClick() {
		initiateElement();
		final JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", element.get()); 
		jse.executeScript("arguments[0].click();", element.get());
		
	}

	@Override
	public void hoverAndClick() {
		initiateElement();
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(element.get()).click().build().perform();
		
	}

	@Override
	public void switchToFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isNotPresent(int timeout) {
		return ElementHandler.waitElementNotPresent(by, timeout);
	}

}
