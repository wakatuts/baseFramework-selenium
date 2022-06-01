package com.wakatuts.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;



public class ConfigReader {

	private static final Properties properties = loadProperties();
	private static final String propertyFilePath = "src//main//resources//test.properties";
	
	private static Properties loadProperties() {
		Properties properties = new Properties();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		return properties;
	}
	
	public static String getStringProperty(String key) {
		String path = properties.getProperty(key);
		if(path != null) {
			return path;
		} else {
			throw new RuntimeException(key + " not specified in the Configuration.properties file");
		}
	}
	
	public static Integer getIntegerProperty(String key) {
		String path = properties.getProperty(key);
		if(path != null) {
			if(StringUtils.isNumeric(path)) {
				return Integer.valueOf(path);
			} else {
				throw new RuntimeException(key + " is not a numeric value!");
			}
		} else {
			throw new RuntimeException(key + " not specified in the Configuration.properties file");
		}
	}
	
	public static Boolean getBooleanProperty(String key) {
		String path = properties.getProperty(key);
		if(path.equalsIgnoreCase("true") || path.equalsIgnoreCase("false")) {
			return Boolean.parseBoolean(path);
		} else {
			throw new RuntimeException(key + " not properly specified in the Configuration.properties file");
		}
	}

}
