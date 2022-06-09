package com.wakatuts.element.widget;

import com.wakatuts.annotations.ImplementedBy;
import com.wakatuts.element.base.Element;

@ImplementedBy(LabelImpl.class)
public interface Label extends Element{
	
	String getFor();

}
