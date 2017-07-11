package com.csc.driverpool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.csc.fixture.SetUpConfiguration;

public class DriverPool {
	private static WebDriver webDriver;
	private static  HashMap<String, WebDriver> webDrivers = new HashMap<>();
	private static WebDriver currentDriver ;
	private static Actions actions;

	public static void createDriver(String key, String browserType){
		switch(browserType){
			case "Chrome": 
				try {
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					webDriver = new RemoteWebDriver(new URL(SetUpConfiguration.configuration.getTestSlaveMachine()), capabilities);
					System.setProperty("webdriver.gecko.driver",
							SetUpConfiguration.configuration.getDriverPath() + "geckodriver.exe");
					webDrivers.put(key, webDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
			case "Firefox":
				try {
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					webDriver = new RemoteWebDriver(new URL(SetUpConfiguration.configuration.getTestSlaveMachine()), capabilities);
					System.setProperty("webdriver.chrome.driver",
							SetUpConfiguration.configuration.getDriverPath() + "chromedriver.exe");
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
	
	public static Actions getActionFromCurrentDriver(){
		return actions = new Actions(currentDriver);
	}
	
	
}
