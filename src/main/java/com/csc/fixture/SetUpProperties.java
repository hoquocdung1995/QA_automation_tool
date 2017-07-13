package com.csc.fixture;

import org.apache.log4j.Logger;

import com.csc.storage.Property;

public class SetUpProperties {

	public SetUpProperties() {
	}

	public void setProperty(String fileName, String value, String property) {
		Property.setProperty(fileName, value, property);
	}

}
