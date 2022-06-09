package com.wakatuts.pages;

import org.openqa.selenium.By;

import com.wakatuts.element.base.Element;
import com.wakatuts.element.base.ElementImpl;

public interface CommonObjects {
	
	//Menu Bar Elements
	
	public static final Element menuContact = new ElementImpl(By.xpath("//a[@href='#/contact']"), "Contact menu option");
	public static final Element menuShop = new ElementImpl(By.xpath("//a[@href='#/shop']"), "Shop menu option");
	
	//Loading elements

	public static final Element loader = new ElementImpl(By.xpath("//div[contains(@class,'progress-info')]"), "Loader");
}
