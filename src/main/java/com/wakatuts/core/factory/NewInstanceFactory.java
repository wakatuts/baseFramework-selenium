package com.wakatuts.core.factory;

import java.lang.reflect.ParameterizedType;

public class NewInstanceFactory {

	@SuppressWarnings("unchecked")
	public static <T> T createByTypeParameter(Class<?> parameterClass, int index) {
		try {
			Class<T> elementsClass = (Class<T>) ((ParameterizedType) parameterClass.getGenericSuperclass()).getActualTypeArguments()[index];
			return (T) elementsClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> String retrieveTypeParameter(Class<?> parameterClass, int index) {
		try {
			Class<?> elementsClass = (Class<T>) ((ParameterizedType) parameterClass.getGenericSuperclass()).getActualTypeArguments()[index];
			return elementsClass.getSimpleName();
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
