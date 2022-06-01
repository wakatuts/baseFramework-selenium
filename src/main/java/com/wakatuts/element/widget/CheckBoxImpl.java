package com.wakatuts.element.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wakatuts.element.base.ElementImpl;

public class CheckBoxImpl extends ElementImpl implements CheckBox{


    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param element to wrap up
     */
    public CheckBoxImpl(By by, String elementName) {
        super(by, elementName);
    }
    
    public CheckBoxImpl(WebElement element, String elementName) {
    	super(element, elementName);
    }

    public void toggle() {
        getWrappedElement().click();
    }

    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }

}
