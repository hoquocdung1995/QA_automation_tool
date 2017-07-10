package com.csc.fixture;

import org.apache.log4j.Logger;

import com.csc.storage.Configuration;

public class SetUpConfiguration {

	private static org.apache.log4j.Logger log = Logger.getLogger(SetUpConfiguration.class);

	public static Configuration configuration = new Configuration();

	public SetUpConfiguration() {
		log.info("SetUpConfiguration()");
	}

	public void setFileConfig(String fileName) {
		configuration.setFileConfig(fileName);
		log.info("Set File Config: " + fileName);
	}

	public void setDriverPath(String driverPath){
		configuration.setDriverPath(driverPath);
	}

	public void setTestSlaveMachine(String machineUrl) {
		configuration.setTestSlaveMachine(machineUrl);
		log.info("setTestSlaveMachine: " + machineUrl);
	}

	public void setUrl(String url) {
		configuration.setUrl(url);
		log.info("setUrl: " + url);
	}

}
