package com.csc.driverpool;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFirefox {
private static FirefoxDriver driver = new FirefoxDriver();
	
	public static FirefoxDriver getDriver(){
		return driver;
	}
}
