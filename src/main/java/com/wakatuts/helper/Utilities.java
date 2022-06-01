package com.wakatuts.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Utilities {

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
	
	public static String generateRandomString(int length, boolean letters, boolean numbers) {
		return RandomStringUtils.random(length, letters, numbers);
	}

}
