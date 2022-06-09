package com.wakatuts.element.base;

import com.wakatuts.annotations.ImplementedBy;

@ImplementedBy(WebListImpl.class)
public interface WebList<E> {

	int size();
	
	boolean isEmpty();
	
	boolean contains(Object o);
	
	E getElementByIndex(int index);
	
	E getElementByText(String text);
	
	E getElementByValue(String value);
	
	E getElementByAttribute(String attribute, String value);

}
