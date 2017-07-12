package com.csc.storage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.csc.fixture.SetUpConfiguration;

/**
 * @author Vo Trung Tin
 */

public class Property {
	/**
	 * method write new file property
	 * if File already exists, then write more data in old file 
	 * @param fileName: name of file property
	 * @param value: locator of 1 property
	 * @param property: 
	 */
	public static void setProperty(String fileName, String value, String property) {
		Properties prop = new Properties();
		OutputStream output = null;
		
		//get path of system
		String path = SetUpConfiguration.configuration.getUrl() + "/" + fileName;
		try {
			/*
			 * create new or write more file property with path.
			 * don't delete old data in file
			 */
			output = new FileOutputStream(path, true);
			prop.setProperty(value, property);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					// close OutputStream
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
