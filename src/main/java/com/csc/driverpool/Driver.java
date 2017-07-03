package com.csc.driverpool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.fixture.SetUpConfiguration;

public class Driver {

	 static SetUpConfiguration conf = new SetUpConfiguration();
	
	public static String  getBrowserName(){
		if("firefox".equalsIgnoreCase("firefox")){
			return "firefox";
		}else if("chrome".equalsIgnoreCase(conf.configuration.getBrowser())){
			return "chrome";
		}
		return "";
	}

	
	public static WebDriver getDriver(){
	
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		if(getBrowserName().equals("firefox"))
		{
			driver = DriverFirefox.getDriver();
//			capabilities=DesiredCapabilities.firefox();
//			capabilities.setCapability("version", "");
//			capabilities.setBrowserName("firefox");
//			capabilities.setCapability("platform", Platform.WINDOWS);
//			try {
//				driver = new RemoteWebDriver(new URL("http://20.203.139.16:4444/wd/hub"), capabilities);
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				driver.manage().window().setPosition(new Point(220, 10));
//				driver.manage().window().setSize(new Dimension(1000, 650));
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}
			
		else if(getBrowserName().equals("chrome"))				
			driver = DriverChrome.getDriver();
			
		return driver;
	}
	
//	
//	public static  WebDriver open() {
//
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		DesiredCapabilities capabilities = null;
//		
//		String browser = "firefox";
//		String browserdriver = SetUpConfiguration.configuration.getDriver();
//		String testSlaveMachine = SetUpConfiguration.configuration.getTestSlaveMachine();
//		String url = SetUpConfiguration.configuration.getUrl();
//		
//		if (browser.equalsIgnoreCase("FIREFOX")) {
//			capabilities=DesiredCapabilities.firefox();
//			BrowserIdentity browserIdentity = (BrowserIdentity) applicationContext.getBean("firefox");
//			browserdriver = System.setProperty(browserIdentity.getNamedriver(), browserIdentity.getPathtodriver());
//		//	webDriver = new FirefoxDriver();
//			capabilities.setCapability("version", "");
//			capabilities.setBrowserName("firefox");
//			capabilities.setCapability("platform", Platform.WINDOWS);
////			try {
////				webDriver = new RemoteWebDriver(new URL(testSlaveMachine), capabilities);
////				webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////				webDriver.manage().window().setPosition(new Point(220, 10));
////				webDriver.manage().window().setSize(new Dimension(1000, 650));
////			} catch (MalformedURLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			webDriver.get(url);
////			Thread.sleep(5000);
////			// //webDriver.close();
////			System.exit(0);
//		} else if (browser.equalsIgnoreCase("CHROME")) {
//			capabilities = DesiredCapabilities.chrome();
//			BrowserIdentity browserIdentity = (BrowserIdentity) applicationContext.getBean("chrome");
//			browserdriver = System.setProperty(browserIdentity.getNamedriver(), browserIdentity.getPathtodriver());
//	//		webDriver = new ChromeDriver();		
//			capabilities.setCapability("version", "");
//			capabilities.setBrowserName("chrome");
//			capabilities.setCapability("platform", Platform.WINDOWS);
//			try {
//				webDriver = new RemoteWebDriver(new URL(testSlaveMachine), capabilities);
//				webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				webDriver.manage().window().setPosition(new Point(220, 10));
//				webDriver.manage().window().setSize(new Dimension(1000, 650));
//
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////			webDriver.get(url);
////			Thread.sleep(5000);
////			// //webDriver.close();
////			System.exit(0);
//		}
//		return webDriver;
//	}
}
