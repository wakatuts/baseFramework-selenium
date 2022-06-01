package com.wakatuts.element.handler;

import com.wakatuts.element.annotations.ImplementedBy;
import com.wakatuts.element.base.Element;

public class ImplementedByHandler {

	private ImplementedByHandler() {
		// TODO Auto-generated constructor stub
	}
	
    public static <T> Class<?> getWrapperClass(Class<T> iface) {
        if (iface.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = iface.getAnnotation(ImplementedBy.class);
            Class<?> clazz = annotation.value();
            if (Element.class.isAssignableFrom(clazz)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " + 
                iface.getCanonicalName() + " if you want to extend ");
    }

}
