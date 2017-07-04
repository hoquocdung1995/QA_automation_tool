package com.csc.driverpool;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import com.csc.fixture.SetUpConfiguration;

public class DriverPool {

	private static WebDriver webDriver;

	public static WebDriver open() {

		String browser = SetUpConfiguration.configuration.getBrowser();
		//String browserdriver = SetUpConfiguration.configuration.getDriver();
		String testSlaveMachine = SetUpConfiguration.configuration.getTestSlaveMachine();

		if (browser.equalsIgnoreCase("FIREFOX")) {

			try {
				webDriver =	new RemoteWebDriver(new URL(testSlaveMachine), DesiredCapabilities.firefox());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("CHROME")) {
			try {
				webDriver =	new RemoteWebDriver(new URL(testSlaveMachine), DesiredCapabilities.chrome());
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return webDriver;
	}
	
	public static WebDriver getDriverPool(){
		return webDriver;
	}


}