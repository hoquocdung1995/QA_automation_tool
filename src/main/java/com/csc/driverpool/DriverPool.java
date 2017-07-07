package com.csc.driverpool;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.*;

import com.csc.fixture.InteractWebApplication;
import com.csc.fixture.SetUpConfiguration;

public class DriverPool {
	private static WebDriver webDriver;
	private static String driver = SetUpConfiguration.configuration.getDriver();
	private static String browser = SetUpConfiguration.configuration.getBrowser();
	private static String testSlaveMachine = SetUpConfiguration.configuration.getTestSlaveMachine();

	public static WebDriver createDriverPool() {
		switch (driver) {
		case TestConstant.DRIVER_FIREFOX:
			try {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				if (browser.equalsIgnoreCase("firefox"))
					capabilities.setBrowserName(BrowserType.FIREFOX);
				capabilities.setPlatform(Platform.WIN10);
				webDriver = new RemoteWebDriver(new URL(testSlaveMachine), capabilities);
				System.setProperty("webdriver.gecko.driver","C:/Users/training/Desktop/MINHLOC/driverBrowser/chromedriver/geckodriver.exe");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case TestConstant.DRIVER_CHROME:
			try {
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				if (browser.equalsIgnoreCase("chrome"))
					capabilities.setBrowserName(BrowserType.CHROME);
				capabilities.setPlatform(Platform.WIN10);
				webDriver = new RemoteWebDriver(new URL(testSlaveMachine), capabilities);
				System.setProperty("webdriver.chrome.driver","C:/Users/training/Desktop/MINHLOC/driverBrowser/chromedriver/chromedriver.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			
			break;
		}
		return webDriver;
	}

	public static WebDriver getDriverPool(){
		return webDriver;
	}
	
	
	public static WebDriver closeDriverPool(){
		webDriver.close();
		return webDriver;
	}

}