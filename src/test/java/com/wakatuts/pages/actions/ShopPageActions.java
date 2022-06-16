package com.wakatuts.pages.actions;

import java.util.Map;

import com.wakatuts.page.actions.IActions;
import com.wakatuts.pages.ShopPage;

public class ShopPageActions extends ShopPage implements IActions {
	
	public ShopPageActions addToyToCart(String toyName, int count) {
		for (int i = 0; i < count; i++) {
			getBuyButtonForItem(toyName).click();
		}
		return this;
	}
	
	public ShopPageActions addToysToCart(Map<String, Integer> toyMap) {
		for(String toyName : toyMap.keySet()) {
			addToyToCart(toyName, toyMap.get(toyName));
		}
		return this;
	}
	
	@Override
	public Boolean isNavigatedToPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
