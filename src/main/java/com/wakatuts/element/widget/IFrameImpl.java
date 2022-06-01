package com.wakatuts.element.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wakatuts.element.base.ElementImpl;


public class IFrameImpl extends ElementImpl implements IFrame {

	public IFrameImpl(WebElement element, String elementName) {
		super(element, elementName);
	}
	
	public IFrameImpl(By by, String elementName) {
		super(by, elementName);
	}
}
