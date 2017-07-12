package com.csc.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.csc.api.ActionAPI;
import com.csc.driverpool.DriverPool;
import com.csc.exception.FixtureException;
import com.csc.fixture.InteractWebApplication;
import com.csc.fixture.SetUpConfiguration;

public class PageAction {
	private static org.apache.log4j.Logger log = Logger.getLogger(InteractWebApplication.class);

	public static void openNewBrowser(String key, String browserType) {
		DriverPool.createDriver(key, browserType);
		ActionAPI.setDriverForAction(key);
	}

	public static void switchToBrowser(String key) {
		ActionAPI.setDriverForAction(key);
	}

	public static void iWaitForMs(String time) {
		ActionAPI.toPause(time);
	}

	public static ArrayList<String> readLocator(String locator) {
		ArrayList<String> list = null;
		Properties prop = new Properties();
		try {
			// load a properties file from class path, inside static method
			// String file =
			// "C:/Users/training//Desktop/FitNesse/FitNesseRoot/bin/locator.properties";
			String filename = SetUpConfiguration.configuration.getUrl() + "/"
					+ SetUpConfiguration.configuration.getFileConfig();
			prop.load(new FileInputStream(filename));

			String str = prop.getProperty(locator);
			String[] words = str.split("=>");
			String type = words[0];
			String val = words[1];

			list = new ArrayList<String>();
			list.add(type);
			list.add(val);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static ArrayList<String> readLocator2(String locator1, String locator2) {
		ArrayList<String> list = null;
		Properties prop = new Properties();
		try {
			// load a properties file from class path, inside static method
			String filename = SetUpConfiguration.configuration.getFileConfig();
			prop.load(new FileInputStream(filename));
			String str = prop.getProperty(locator1);
			String[] words = str.split("=>");
			String type = words[0];
			String val = words[1];
			String str2 = prop.getProperty(locator2);
			String[] words2 = str2.split("=>");
			String type2 = words2[2];
			String val2 = words2[3];
			list = new ArrayList<String>();
			list.add(type);
			list.add(val);
			list.add(type2);
			list.add(val2);
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static void iNavigateToPage(String url) {
		try {
			System.out.println("Page Navigate");
			ActionAPI.toNavigate(url);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iClickTheElement(String locator) throws InterruptedException {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toClick(list.get(0), list.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iShouldSeeThePopupAppears(String windowId) {
		try {
			ActionAPI.toShowPopUp(windowId);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iOpenThePopupWindowWith(String url, String windowId) {
		try {
			ActionAPI.toOpenPopUpWithUrl(url, windowId);
		} catch (Exception e) {

		}
	}

	public static void iCloseTheBrowser() {
		try {
			ActionAPI.toCloseBrowser();
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iDoubleClickTheElement(String locator) {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toDoubleClick(list.get(0), list.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iDragTheElementAndDropToTheElement(String locator1, String locator2) {
		try {
			ArrayList<String> list1 = readLocator(locator1);
			ArrayList<String> list2 = readLocator(locator2);
			ActionAPI.toDragAndDrop(list1.get(0), list1.get(1), list2.get(0), list2.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iMoveTheFocusToTheElement(String locator) {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toMoveTheFocusToElement(list.get(0), list.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iPressTheLeftMouseButtonOnTheElement(String locator) {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toPressLeftMouse(list.get(0), list.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iReleaseTheLeftMouseButtonOnTheElement(String locator) {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toReleaseMouse(list.get(0), list.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iPause(String waitTime) {
		try {
			ActionAPI.toPause(waitTime);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iRefresh() {
		try {
			ActionAPI.toRefresh();
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iSelectTheOptionFromADropDown(String optionLocator, String input) {
		try {
			ArrayList<String> list = readLocator(optionLocator);
			ActionAPI.toSelectDropdownList(list.get(0), list.get(1), input);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iSetTheInputWithValue(String locator, String value) {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toSetInput(list.get(0), list.get(1), value);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iWaitForANewPageToLoad(String type, String value, String timeOut) {
		try {
			ActionAPI.toWaitforProperty(type, value, timeOut);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iGiveFocusToTheCurrentlySelectedWindow() {
		try {
			ActionAPI.toGiveFocusToCurrentWindow();
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iExecuteJavascriptOnElement(String script, String locator) {
		try {
			ArrayList<String> list = readLocator(locator);
			ActionAPI.toExcuteJavascript(script, list.get(0), list.get(1));
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void iResizeCurrentlySelectedWindowToTakeUpTheEntireScreen() {
		try {
			ActionAPI.toResizeWindown();
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	public static void switchToWindow(String title) {
		try {
			ActionAPI.toSwitchWindow(title);
		} catch (Exception e) {
			exThrowable(e);
		}
	}

	/**
	 * use exception fitnesse
	 * 
	 * @param exception
	 */
	public static void exThrowable(Exception e) {
		throw new FixtureException(e);
	}
}