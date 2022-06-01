package com.wakatuts.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wakatuts.pages.HomePage;
import com.wakatuts.pages.actions.HomePageActions;

public class HomeTest extends BaseTest {
	
	@Test
	public static void homePageTest() {
		openBrowser("https://jupiter.cloud.planittesting.com");
		HomePageActions.clickNavBar();
//		Utilities.sleep(5000);
		//https://jupiter.cloud.planittesting.com
	}

}
