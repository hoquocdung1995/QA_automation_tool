package com.csc.fixture;

import org.apache.log4j.Logger;

public class SetUpConfiguration {

	private static org.apache.log4j.Logger log = Logger.getLogger(SetUpConfiguration.class);

	public SetUpConfiguration() {
		log.info("SetUpConfiguration()");
	}

	public void setFileConfig(String fileName) {
		log.info("Set File Config: " + fileName);
	}

	public void setBrowser(String browser) {
		log.info("setBrowser: " + browser);
	}

	public void setDriver(String driver) {
		log.info("setDriver: " + driver);
	}

	public void setTestSlaveMachine(String machineUrl) {
		log.info("setTestSlaveMachine: " + machineUrl);
	}

	public void setUrl(String url) {
		log.info("setUrl: " + url);
	}

}
