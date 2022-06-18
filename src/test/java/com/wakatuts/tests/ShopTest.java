package com.wakatuts.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.wakatuts.core.Verify;
import com.wakatuts.driver.Driver;
import com.wakatuts.pages.actions.CartPageActions;
import com.wakatuts.pages.actions.CommonObjectActions;

public class ShopTest extends BaseTest {

	@Test(description="Test Case 3")
	public static void addItemInCartTest() {
		Driver.openBrowser("http://jupiter.cloud.planittesting.com");
		Map<String, Integer> toyMap = new HashMap<>();
		toyMap.put("Funny Cow", 2);
		toyMap.put("Fluffy Bunny", 1);
		CommonObjectActions.goToShop()
				.addToysToCart(toyMap);
		CartPageActions cartActions = CommonObjectActions.goToCart();
		Verify.isTrue(cartActions.areItemsInCart(toyMap), "All items bought are in the cart");
	}
	
	@Test(description="Test Case 4")
	public static void totalCartCalculationTest() {
		Driver.openBrowser("http://jupiter.cloud.planittesting.com");
		Map<String, Integer> toyMap = new HashMap<>();
		toyMap.put("Stuffed Frog", 2);
		toyMap.put("Fluffy Bunny", 5);
		toyMap.put("Valentine Bear", 3);
		CommonObjectActions.goToShop().addToysToCart(toyMap);
		CartPageActions cartActions = CommonObjectActions.goToCart();
		Verify.equals(cartActions.getActualCartTotal(), cartActions.getCalculatedCartTotal());
		Verify.isTrue(cartActions.isSubTotalEqualToPriceTimesQuantity(), "Subtotal is equal to price times quantity");
	}
	
}
