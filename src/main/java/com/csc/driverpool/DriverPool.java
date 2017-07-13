package com.csc.driverpool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.csc.fixture.SetUpConfiguration;

public class DriverPool {
	private static WebDriver webDriver;
	private static  HashMap<String, WebDriver> webDrivers = new HashMap<>();
	private static WebDriver currentDriver ;

	public static void createDriver(String key, String browserType){
		switch(browserType){	
			case "Firefox": 
				try {
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					webDriver = new RemoteWebDriver(new URL(SetUpConfiguration.configuration.getTestSlaveMachine()), capabilities);
					System.setProperty(TestConstant.DRIVER_FIREFOX,
							SetUpConfiguration.configuration.getDriverPath() + TestConstant.DRIVER_FIREFOX_FILE);
					webDrivers.put(key, webDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;	
			case "Chrome":
				try {
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					webDriver = new RemoteWebDriver(new URL(SetUpConfiguration.configuration.getTestSlaveMachine()), capabilities);
					System.setProperty(TestConstant.DRIVER_CHROME,
							SetUpConfiguration.configuration.getDriverPath() + TestConstant.DRIVER_CHROME_FILE);
					webDrivers.put(key, webDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
		}
	}
	
	public static WebDriver getDriver(String key){
		currentDriver = webDrivers.get(key);
		return currentDriver;
	}
	
	public static WebDriver getCurrentDriver(){
		return currentDriver;
	}
	
	
}
