package com.csc.fixture;

import com.csc.storage.Properties;

public class SetUpProperties {

	public SetUpProperties() {
	}

	public void setProperty(String fileName, String value, String property) {
		Properties.setProperty(fileName, value, property);
	}

}
