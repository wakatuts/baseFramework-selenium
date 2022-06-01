package com.wakatuts.element.widget;

import com.wakatuts.element.annotations.ImplementedBy;
import com.wakatuts.element.base.Element;

@ImplementedBy(LabelImpl.class)
public interface Label extends Element{
	
	String getFor();

}
