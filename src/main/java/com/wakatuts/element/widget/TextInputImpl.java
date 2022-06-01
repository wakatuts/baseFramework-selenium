package com.wakatuts.element.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        getWrappedElement().clear();
    }

    @Override
    public void set(Object text) {
        WebElement element = getWrappedElement();
        element.clear();
        element.sendKeys(String.valueOf(text));
    }

    /**
     * Gets the value of an input field.
     * @return String with the value of the field.
     */
    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }

}
