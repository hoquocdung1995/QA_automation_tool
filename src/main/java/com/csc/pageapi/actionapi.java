package com.csc.pageapi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class actionapi {
	private WebDriver driver;

	public boolean toNavigate(String url) throws Exception {
		driver.navigate().to(url);
		return true;
	}

	/*
	 * public By convertLocator(String locator) { String array[] =
	 * locator.split("-"); By byInfo = null; for (String a : array) { String q[]
	 * = a.split("=>"); if ("id".equals(q[0])) { byInfo = By.ById.id(q[1]); }
	 * else if ("name".equals(q[0])) { byInfo = By.name(q[1]); } } return
	 * byInfo; }
	 */

	public By convertLocator(String locator) {
		// Read value using the logical name as Key
		// String ElementName = properties.getProperty(locator);
		// Split the value which contains locator type and locator value
		String locatorType = locator.split("=>")[0];
		String locatorValue = locator.split("=>")[1];
		// Return a instance of By class based on type of locator
		if (locatorType.toLowerCase().equals("id")) {
			return By.id(locatorValue);
		} else if (locatorType.toLowerCase().equals("name")) {
			return By.name(locatorValue);
		} else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class"))) {
			return By.className(locatorValue);
		} else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag"))) {
			return By.className(locatorValue);
		} else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link"))) {
			return By.linkText(locatorValue);
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			return By.partialLinkText(locatorValue);
		} else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css"))) {
			return By.cssSelector(locatorValue);
		} else if (locatorType.toLowerCase().equals("xpath")) {
			return By.xpath(locatorValue);
		}
		return null;
	}

	public String readProperty() {
		FileInputStream fileInput = null;
		File file = new File("D:/workspace_Dung/FinalSpring/src/dataFile.properties");
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cant find file");
			e.printStackTrace(System.out);
		}
		Properties protertyFile = new Properties();
		try {
			protertyFile.load(fileInput);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(System.out);
		}

		Enumeration values = protertyFile.keys();
		String valuesGoal = "";
		while (values.hasMoreElements()) {
			String key = (String) values.nextElement();
			String keyValues = protertyFile.getProperty(key);
			valuesGoal = valuesGoal + keyValues + "-";
		}
		return valuesGoal;
	}

	/*
	 * public boolean readProperty(String locatorFile) { FileInputStream
	 * fileInput = null; File file = new File(locatorFile); try { fileInput =
	 * new FileInputStream(file); } catch (Exception e) { // TODO: handle
	 * exception System.out.println("Don't finding a file");
	 * e.printStackTrace(System.out); } Properties protertyFile = new
	 * Properties(); try { protertyFile.load(fileInput); } catch (Exception e) {
	 * // TODO: handle exception e.printStackTrace(System.out); } Enumeration
	 * values = protertyFile.keys(); while (values.hasMoreElements()) { String
	 * key = (String) values.nextElement(); String keyValues =
	 * protertyFile.getProperty(key); System.out.println(":-" + keyValues); }
	 * return true; }
	 */

	public boolean isElementIsPresent(By element) {
		try {
			return driver.findElement(element) != null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(System.out);
			return false;
		}
	}

	private static final int ARG_PAUSE_MSEC = 0;

	// Switch
	public boolean SwitchTo(String WindowName) {
		driver.switchTo().window(WindowName);
		return true;
	}

	// Refresh
	public boolean RefresherPage(String Browser) {
		driver.navigate().refresh();
		return true;
	}

	// Pause
	public void Pause(int WaitTime) throws InterruptedException {
		WaitTime = ARG_PAUSE_MSEC;
		Thread.sleep((WaitTime));
	}

	public boolean close() {
		driver.quit();
		return true;
	}
}
