package com.csc.fixture;

import org.apache.log4j.Logger;

import com.csc.storage.Configuration;

public class SetUpConfiguration {

	public static Configuration configuration = new Configuration();

	public SetUpConfiguration() {

	}

	public void setFileConfig(String fileName) {
		configuration.setFileConfig(fileName);
	}

	public void setDriverPath(String driverPath){
		configuration.setDriverPath(driverPath);
	}

	public void setTestSlaveMachine(String machineUrl) {
		configuration.setTestSlaveMachine(machineUrl);
	}

	public void setUrl(String url) {
		configuration.setUrl(url);
	}

}
