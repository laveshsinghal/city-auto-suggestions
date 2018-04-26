package com.search.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class which loads the config properties file and provides the
 * flexibility making use java Properties instance with simple key value pair.
 * 
 * @author Lavesh Singhal
 *
 */
public class ApplicationProperties {

	public static Properties properties;
	
	/**
	 * configure properties from file to key value pair. 
	 * @throws IOException
	 */
	public static void configure() throws IOException {

		properties = new Properties();
		InputStream inputStream = ApplicationProperties.class.getClassLoader().getResourceAsStream("config.properties");
		properties.load(inputStream);
		inputStream.close();
	}
	
	/**
	 * get the specified keyed property.
	 * @param  String key
	 * @return String value
	 * @throws IOException
	 */
	public static String getProperty(String key) throws IOException {
		if (properties == null) {
			ApplicationProperties.configure();
		}
		return properties.getProperty(key);
	}
}
