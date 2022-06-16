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
		TestLogger.setPass("Actual string is \'" + actual + "\'");
	}
	
	public static void equals(Double actual, Double expected) {
		Assert.assertEquals(actual, expected, actual + " is not equal to " + expected);
		TestLogger.setPass("Actual number is \'" + actual + "\'");
	}
	
	public static void contains(String mainString, String expected) {
		Assert.assertTrue(mainString.contains(expected), mainString + " does not contain " + expected);
		TestLogger.setPass(mainString + " contains " + expected);
	}
	
	public static void equalsIgnoreCase(String actual, String expected) {
		Assert.assertTrue(actual.equalsIgnoreCase(expected), 
				actual + " does not equals ignore case to " + expected);
		TestLogger.setPass("Actual string is " + actual + "\'");
	}
	
	public static void isTrue(Boolean condition, String expectedResult) {
		Assert.assertTrue(condition, "expected result \'" + expectedResult + "\' is not met");
		TestLogger.setPass(expectedResult);
	}
		
	public static void isFalse(Boolean condition, String expectedResult) {
		Assert.assertFalse(condition, "expected result \'" + expectedResult + "\' is not met");
		TestLogger.setPass(expectedResult);
	}
	
	public static void softEquals(String actual, String expected) {
		softAssert.get().assertEquals(actual, expected, actual + " is not equal to " + expected);
		TestLogger.setPass("Actual string is \'" + actual + "\'");
	}
	
	public static void softContains(String mainString, String expected) {
		softAssert.get().assertTrue(mainString.contains(expected), mainString + " does not contain " + expected);
		TestLogger.setPass(mainString + " contains " + expected);
	}
	
	public static void softEqualsIgnoreCase(String actual, String expected) {
		softAssert.get().assertTrue(actual.equalsIgnoreCase(expected), 
				actual + " does not equals ignore case to " + expected);
		TestLogger.setPass("Actual string is \'" + actual + "\'");
	}

}
