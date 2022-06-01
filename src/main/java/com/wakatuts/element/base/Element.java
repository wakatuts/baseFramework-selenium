package com.wakatuts.element.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

import com.wakatuts.element.annotations.ImplementedBy;


@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, WrapsElement, Locatable{
	
	boolean elementWired();
	
	boolean isPresent();
	
	void forceClick();
	
	void hoverAndClick();
	
	void switchToFrame();

	boolean isPresent(int timeout);
	
	boolean isNotPresent(int timeout);

}
