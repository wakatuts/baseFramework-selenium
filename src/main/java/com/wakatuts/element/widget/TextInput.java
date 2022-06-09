package com.wakatuts.element.widget;

import com.wakatuts.annotations.ImplementedBy;
import com.wakatuts.element.base.Element;

@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element{
	
    /**
     * @param object The text to type into the field.
     */
    void set(Object object);

}
