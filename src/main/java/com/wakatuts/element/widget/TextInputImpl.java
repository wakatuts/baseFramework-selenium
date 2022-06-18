package com.wakatuts.element.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wakatuts.core.TestLogger;
import com.wakatuts.element.base.ElementImpl;


public class TextInputImpl extends ElementImpl implements TextInput{

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public TextInputImpl(WebElement element, String elementName) {
        super(element, elementName);
    }
    
    public TextInputImpl(By by, String elementName) {
        super(by, elementName);
    }

    @Override
    public void clear() {
    	TestLogger.setInfo("ACTION", "Clearing text from " + this.elementName);
        getWrappedElement().clear();
    }

    @Override
    public void set(Object text) {
        WebElement element = getWrappedElement();
        TestLogger.setInfo("ACTION", "Setting \'"+ text +"\' to " + this.elementName);
        element.clear();
        element.sendKeys(String.valueOf(text));
    }

}
