package com.wakatuts.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.Status;

public class TestLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);
	
	public static void setInfo(String messageType, String message) {
		ExtentReportHandler.getTest().log(Status.INFO, "[" + messageType.toUpperCase() + "] " + message);
		logger.info("[" + messageType.toUpperCase() + "] " + message);
	}
	
	public static void setPass(String message) {
		ExtentReportHandler.getTest().log(Status.PASS, message);
		logger.info("[PASSED] " + message);
	}
	
	public static void setFail(String message) {
		ExtentReportHandler.getTest().log(Status.FAIL, message);
		logger.error("[FAILED] " + message);
	}

}
