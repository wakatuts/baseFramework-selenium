package com.wakatuts.pages;

import org.openqa.selenium.By;

import com.wakatuts.element.base.Element;
import com.wakatuts.element.base.ElementImpl;

public class ShopPage {
	
	protected static Element getBuyButtonForItem(String toyName) {
		return new ElementImpl(By.xpath("//*[text()='" + toyName + "']/following-sibling::*/a[text()='Buy']"), "Buy button for "+ toyName);
	}

}
