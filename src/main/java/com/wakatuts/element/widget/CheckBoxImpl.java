package com.wakatuts.element.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wakatuts.core.TestLogger;
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
    	TestLogger.setInfo("ACTION", "Toggling " + this.elementName);
        getWrappedElement().click();
    }

    public void check() {
    	TestLogger.setInfo("ACTION", "Checking " + this.elementName);
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
    	TestLogger.setInfo("ACTION", "Unchecking " + this.elementName);
        if (isChecked()) {
            toggle();
        }
    }

    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }

}
