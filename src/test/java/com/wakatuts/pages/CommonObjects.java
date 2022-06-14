package com.wakatuts.pages;

import org.openqa.selenium.By;

import com.wakatuts.element.base.Element;
import com.wakatuts.element.base.ElementImpl;

public class CommonObjects {
	
	//Menu Bar Elements
	
	protected static final Element menuContact = new ElementImpl(By.xpath("//a[@href='#/contact']"), "Contact menu option");
	protected static final Element menuShop = new ElementImpl(By.xpath("//a[@href='#/shop']"), "Shop menu option");
	
	//Loading elements

	protected static final Element loader = new ElementImpl(By.xpath("//div[contains(@class,'progress-info')]"), "Loader");
}
