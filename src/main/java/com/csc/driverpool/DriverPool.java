package com.csc.driverpool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverPool {
	private static WebDriver webDriver;
	private static  HashMap<String, WebDriver> webDrivers = new HashMap<>();
	private static WebDriver currentDriver ;

	public static void createDriver(String key, String browserType){
		switch(browserType){
			case "Chrome": 
				try {
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4445/wd/hub"), capabilities);
					System.setProperty("webdriver.gecko.driver",
							"C:/Users/training/Desktop/MINHLOC/driverBrowser/chromedriver/geckodriver.exe");
					webDrivers.put(key, webDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
			case "Firefox":
				try {
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4445/wd/hub"), capabilities);
					System.setProperty("webdriver.chrome.driver",
							"C:/Users/training/Desktop/MINHLOC/driverBrowser/chromedriver/chromedriver.exe");
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
