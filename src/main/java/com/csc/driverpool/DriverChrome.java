package com.csc.driverpool;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChrome {
	private static ChromeDriver driver = new ChromeDriver();
	
	public static ChromeDriver getDriver(){
		return driver;
	}
}
