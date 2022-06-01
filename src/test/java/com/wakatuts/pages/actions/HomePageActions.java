package com.wakatuts.pages.actions;

import com.wakatuts.pages.HomePage;

public class HomePageActions extends HomePage{
	
	public static void clickNavBar() {
		logo.click();
		navBar.getElementByIndex(1).click();
	}

}
