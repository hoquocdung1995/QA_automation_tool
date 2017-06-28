package com.csc.fixture;

import org.apache.log4j.Logger;

import com.csc.storage.Properties;

public class SetUpProperties {

	private static org.apache.log4j.Logger log = Logger.getLogger(SetUpProperties.class);

	public SetUpProperties() {
	}

	public void setProperty(String fileName, String value, String property) {
		Properties.setProperty(fileName, value, property);
	}

}
