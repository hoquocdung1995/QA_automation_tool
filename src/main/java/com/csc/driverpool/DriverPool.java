package com.csc.driverpool;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.fixture.*;
import com.csc.storage.*;
import com.thoughtworks.selenium.*;

public class DriverPool {
	
	private static WebDriver webDriver;

	public WebDriver open() throws MalformedURLException, InterruptedException {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		DesiredCapabilities capabilities = null;
		
		String browser = SetUpConfiguration.configuration.getBrowser();
		String browserdriver = SetUpConfiguration.configuration.getDriver();
		String testSlaveMachine = SetUpConfiguration.configuration.getTestSlaveMachine();
		String url = SetUpConfiguration.configuration.getUrl();
		
		if (browser.equalsIgnoreCase("FIREFOX")) {
			
		//	return FirefoxDriver.getDriver();
			
			capabilities=DesiredCapabilities.firefox();
			BrowserIdentity browserIdentity = (BrowserIdentity) applicationContext.getBean("firefox");
			browserdriver = System.setProperty(browserIdentity.getNamedriver(), browserIdentity.getPathtodriver());
			webDriver = new FirefoxDriver();
			capabilities.setCapability("version", "");
			capabilities.setBrowserName("firefox");
			capabilities.setCapability("platform", Platform.WINDOWS);
			try {
				webDriver = new RemoteWebDriver(new URL(testSlaveMachine), capabilities);
				webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webDriver.manage().window().setPosition(new Point(220, 10));
				webDriver.manage().window().setSize(new Dimension(1000, 650));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			webDriver.get(url);
			Thread.sleep(5000);
			// //webDriver.close();
			System.exit(0);
		} else if (browser.equalsIgnoreCase("CHROME")) {
			capabilities = DesiredCapabilities.chrome();
			BrowserIdentity browserIdentity = (BrowserIdentity) applicationContext.getBean("chrome");
			browserdriver = System.setProperty(browserIdentity.getNamedriver(), browserIdentity.getPathtodriver());
			webDriver = new ChromeDriver();		
			capabilities.setCapability("version", "");
			capabilities.setBrowserName("chrome");
			capabilities.setCapability("platform", Platform.WINDOWS);
			try {
				webDriver = new RemoteWebDriver(new URL(testSlaveMachine), capabilities);
				webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webDriver.manage().window().setPosition(new Point(220, 10));
				webDriver.manage().window().setSize(new Dimension(1000, 650));

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			webDriver.get(url);
			Thread.sleep(5000);
			// //webDriver.close();
			System.exit(0);
		}
		return webDriver;
	}

}
