package com.wakatuts.pages.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.wakatuts.core.TestLogger;
import com.wakatuts.page.actions.IActions;
import com.wakatuts.pages.CartPage;

public class CartPageActions extends CartPage implements IActions {
	
	public Boolean areItemsInCart(Map<String, Integer> toyMap) {
		List<String> toyList = new ArrayList<>();
		toyList.addAll(toyMap.keySet());
		if(!toyList.equals(tableCartItems.getAllTextsOfAColumn(1))){
			return false;
		}
		int i = 0;
		for(String toyName : toyMap.keySet()) {
			if(!String.valueOf(toyMap.get(toyName)).equals(textInputQuantity.getElementByIndex(i).getAttribute("value"))) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	public Double getCalculatedCartTotal() {
		Double total = 0.00;
		for(int i=0; i < tableCartItems.getBodyRowCount(); i++) {
			total += Double.valueOf(tableCartItems.getCellAtIndex(i, 3).getText().substring(1));
		}
		return total;
	}
	
	public Double getActualCartTotal() {
		return Double.valueOf(labelTotal.getText().substring(7).trim());
	}
	
	public Boolean isSubTotalEqualToPriceTimesQuantity() {
		String actualSubTotal = "";
		double calculatedSubTotal = 0;
		for(int i=0; i < tableCartItems.getBodyRowCount(); i++) {
			actualSubTotal = tableCartItems.getCellAtIndex(i, 3).getText().substring(1);
			calculatedSubTotal = Double.valueOf(tableCartItems.getCellAtIndex(i, 1).getText().substring(1)) 
					* Double.valueOf(textInputQuantity.getElementByIndex(i).getAttribute("value"));
			TestLogger.setInfo("INFO", "Calculated subtotal is " + actualSubTotal);
			TestLogger.setInfo("INFO", "Actual subtotal is " + calculatedSubTotal);
			if(!Double.valueOf(actualSubTotal).equals(calculatedSubTotal)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean isNavigatedToPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
