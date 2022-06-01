package com.wakatuts.pages;

import org.openqa.selenium.By;

import com.wakatuts.element.base.Element;
import com.wakatuts.element.base.ElementImpl;
import com.wakatuts.element.base.WebList;
import com.wakatuts.element.base.WebListImpl;
import com.wakatuts.element.widget.CheckBox;
import com.wakatuts.element.widget.CheckBoxImpl;

public class HomePage {
	
	protected static final Element logo = new ElementImpl(By.className("brand"), "JupiterToys Logo");
	protected static final WebList<Element> navBar = new WebListImpl<>(Element.class, By.xpath("//ul[@class='nav']//a"), "Nav Bar buttons"); 

}
