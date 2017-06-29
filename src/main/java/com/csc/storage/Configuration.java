package com.csc.storage;

public class Configuration {

	private String fileConfig;
	private String browser;
	private String driver;
	private String testSlaveMachine;
	private String url;

	public String getFileConfig() {
		return fileConfig;
	}

	public void setFileConfig(String fileConfig) {
		this.fileConfig = fileConfig;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getTestSlaveMachine() {
		return testSlaveMachine;
	}

	public void setTestSlaveMachine(String testSlaveMachine) {
		this.testSlaveMachine = testSlaveMachine;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
