package com.wakatuts.core;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Verify {

	private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<SoftAssert>();
	
	public static void setAssert() {
		softAssert.set(new SoftAssert());
	}
	
	public SoftAssert get() {
		return softAssert.get();
	}
	
	public static void assertAll() {
		softAssert.get().assertAll();
	}
	

	public static void equals(String actual, String expected) {
		Assert.assertEquals(actual, expected, actual + " is not equal to " + expected);
	}
	
	public static void contains(String actual, String expected) {
		Assert.assertTrue(actual.contains(expected), actual + " does not contain " + expected);
	}
	
	public static void equalsIgnoreCase(String actual, String expected) {
		Assert.assertTrue(actual.equalsIgnoreCase(expected), 
				actual + " does not equals ignore case to " + expected);
	}
	
	public static void isTrue(Boolean condition) {
		Assert.assertTrue(condition);
	}
		
	public static void isFalse(Boolean condition) {
		Assert.assertFalse(condition);
	}
	
	public static void softEquals(String actual, String expected) {
		softAssert.get().assertEquals(actual, expected, actual + " is not equal to " + expected);
	}
	
	public static void softContains(String actual, String expected) {
		softAssert.get().assertTrue(actual.contains(expected), actual + " does not contain " + expected);
	}
	
	public static void softEqualsIgnoreCase(String actual, String expected) {
		softAssert.get().assertTrue(actual.equalsIgnoreCase(expected), 
				actual + " does not equals ignore case to " + expected);
	}

}
