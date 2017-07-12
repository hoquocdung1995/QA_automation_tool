package com.csc.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * The object contains the config information
 * @author Vo Trung Tin
 * 
 */
public class Configuration {
	// file name config
	private String fileConfig;
	// url of test slave machine
	private String testSlaveMachine;
	private String url;
	// path of system
	private String driverPath;
	// path of driver file
	public String getDriverPath() {
		return driverPath;
	}

	public String getFileConfig() {
		return fileConfig;
	}

	public void setFileConfig(String fileConfig) {
		this.fileConfig = fileConfig;
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
		createFileProperty();
	}
	
	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}
	/**
	 * when start test case in fitnesse
	 * create new file property
	 * if File already exists, then delete old data 
	 */
	public void createFileProperty() {
		try {
			// get path file property
			String path = getUrl() + "/" + getFileConfig();
			File file = new File(path);
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
