package com.wakatuts.pages;

import org.openqa.selenium.By;

import com.wakatuts.element.base.WebList;
import com.wakatuts.element.base.WebListImpl;
import com.wakatuts.element.widget.Label;
import com.wakatuts.element.widget.LabelImpl;
import com.wakatuts.element.widget.Table;
import com.wakatuts.element.widget.TableImpl;
import com.wakatuts.element.widget.TextInput;

public class CartPage {

	protected static final Table tableCartItems = new TableImpl(By.xpath("//table[contains(@class,'cart-items')]"), "Cart Items table");
	protected static final WebList<TextInput> textInputQuantity = new WebListImpl<>(TextInput.class, By.xpath("//table//td/input"), "Quantity text input");
	protected static final Label labelTotal = new LabelImpl(By.xpath("//strong[contains(@class,'total')]"), "Total Label");

}
