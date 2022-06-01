package com.wakatuts.element.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.wakatuts.element.base.ElementImpl;


@Retention(RUNTIME)
@Target(TYPE)
public @interface ImplementedBy {
	
	Class<?> value() default ElementImpl.class;

}
