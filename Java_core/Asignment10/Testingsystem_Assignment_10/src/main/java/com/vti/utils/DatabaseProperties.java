package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

	public static final String RESOURCE_FOLDER_URL = "C:\\Users\\FPTSHOP\\workspace\\Testingsystem_Assignment_10\\resources\\";
	private Properties properties;

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
