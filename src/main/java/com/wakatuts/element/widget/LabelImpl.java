package com.wakatuts.element.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wakatuts.element.base.ElementImpl;


public class LabelImpl extends ElementImpl implements Label{

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public LabelImpl(WebElement element, String elementName) {
        super(element, elementName);
    }
    
    public LabelImpl(By by, String elementName) {
    	super(by, elementName);
    }

    @Override
    public String getFor() {
        return getWrappedElement().getAttribute("for");
    }

}
