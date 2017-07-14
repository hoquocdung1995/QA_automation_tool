package com.csc.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.csc.action.PageAction;
import com.csc.driverpool.DriverPool;
import com.csc.driverpool.TestConstant;
import com.csc.exception.FixtureException;

public class ActionAPI {

	private static Logger logger = Logger.getLogger(ActionAPI.class);
	private static WebDriver driver;
	private static Select select;
	private static Actions actions;
	private static WebElement element;

	/*
	 * Define Element id, name, x_path, tag name
	 */
	public static By toDefineElement(String type, String value) {
		By by = null;
		if (TestConstant.XPATH.equalsIgnoreCase(type)) {
			by = By.xpath(value);
		} else if (TestConstant.NAME.equalsIgnoreCase(type)) {
			by = By.name(value);
		} else if (TestConstant.ID.equalsIgnoreCase(type)) {
			by = By.id(value);
		} else if (TestConstant.CSS_SELECTOR.equalsIgnoreCase(type) || TestConstant.CSS.equalsIgnoreCase(type)) {
			by = By.cssSelector(value);
		} else if (TestConstant.TAGNAME.equalsIgnoreCase(type) || TestConstant.TAG.equalsIgnoreCase(type)) {
			by = By.cssSelector(value);
		}
		return by;
	}

	public static void setDriverForAction(String key) {
		driver = DriverPool.getDriver(key);
		actions = DriverPool.getActionFromCurrentDriver();
	}

	public static void toSwitchWindow(String title) {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();
		for (String s : windows) {
			driver.switchTo().window(s);
			if (driver.getTitle().contains(title)) {
				return;
			}
		}
		driver.switchTo().window(mainwindow);
	}

	/*
	 * Verify WebElement
	 */
	public static String verifyElementText(String locator) {
		List<String> locators = PageAction.readLocator(locator);
		String type = locators.get(0);
		String elementText = "";
		try {
			if (TestConstant.XPATH.equalsIgnoreCase(type)) {
				elementText = driver.findElement(By.xpath(locators.get(1))).getText();
			} else if (TestConstant.NAME.equalsIgnoreCase(type)) {
				elementText = driver.findElement(By.name(locators.get(1))).getText();
			} else if (TestConstant.ID.equalsIgnoreCase(type)) {
				elementText = driver.findElement(By.id(locators.get(1))).getText();
			}
		} catch (Exception e) {
			logger.debug(e);
			elementText = "Not found";
		}
		return elementText;
	}

	/*
	 * Navigate
	 */
	public static void toNavigate(String url) {
		logger.debug("I navigate");
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	/*
	 * Click
	 */
	public static void toClick(ArrayList<By> locators) throws InterruptedException {
		Boolean isActionSuccess = false;
		int indexOfLocator = 0;
		while ((!isActionSuccess) && (indexOfLocator < locators.size())) {
			try {
				isActionSuccess = true;
				driver.findElement(locators.get(indexOfLocator)).click();
			} catch (Exception e) {
				indexOfLocator++;
				isActionSuccess = false;
				if (indexOfLocator >= locators.size()){
					exThrowable(e);
				}
			}
		}

	}

	/*
	 * set Input for element
	 */
	public static void toSetInput(ArrayList<By> locators, String input) {
		Boolean isActionSuccess = false;
		int indexOfLocator = 0;
		while ((!isActionSuccess) && (indexOfLocator < locators.size())) {
			try {
				isActionSuccess = true;
				driver.findElement(locators.get(indexOfLocator)).sendKeys(input);
			} catch (Exception e) {
				indexOfLocator++;
				isActionSuccess = false;
				if (indexOfLocator >= locators.size()){
					exThrowable(e);
				}
			}
		}
		
	}

	/*
	 * Close browser
	 */
	public static void toCloseBrowser() {
		driver.close();
	}

	/*
	 * Double click element
	 */
	public static void toDoubleClick(String type, String value) {
		actions.doubleClick(driver.findElement(toDefineElement(type, value))).perform();
	}

	/*
	 * Define Element is present or not
	 */
	public static boolean isElementIsPresent(String type, String value) {
		try {
			element = driver.findElement(toDefineElement(type, value));
		} catch (Exception e) {
			if (element == null)
				e.printStackTrace(System.out);
			return false;
		}
		return true;
	}

	/*
	 * Select Option from drop down list
	 */
	public static void toSelectDropdownList(String type, String value, String input) {
		select = new Select(driver.findElement(toDefineElement(type, value)));
		select.selectByVisibleText(input);
	}

	/*
	 * Select_Option//Use_only_NameAttribute
	 */
	public static void toSelectOption(String value, String input) {
		List<WebElement> e = driver.findElements(By.name(value));
		for (int i = 0; i < e.size(); i++) {
			if ((e.get(i).getAttribute("value").equals(input))) {
				e.get(i).click();
			}
		}
	}

	/*
	 * Excute_Javascript
	 */
	public static void toExcuteJavascript(String script, String type, String value) {
		if (driver instanceof JavascriptExecutor) {
			driver.findElement(toDefineElement(type, value));
			((JavascriptExecutor) driver).executeScript(script);
		}
	}

	/*
	 * Drag and drop
	 */
	public static void toDragAndDrop(String type1, String value1, String type2, String value2) {
		actions.dragAndDrop(driver.findElement(toDefineElement(type1, value1)),
				driver.findElement(toDefineElement(type2, value2))).perform();
	}

	/*
	 * Refresh page
	 */
	public static void toRefresh() {
		driver.navigate().refresh();
	}

	/*
	 * Get Element text (by element attribute)
	 */
	public static String toGetElementText(String type, String value) {
		String textElement = null;
		try {
			textElement = driver.findElement(toDefineElement(type, value)).getText();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return textElement;
	}

	/*
	 * Pause (sleep with wait time)
	 */
	public static void toPause(String waitTime) {
		try {
			int time = Integer.valueOf(waitTime);
			Thread.sleep((time));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Wait_For_Property
	 */
	public static void toWaitforProperty(String type, String value, String timeOut) {
		int tOut = Integer.parseInt(timeOut);
		WebDriverWait wait = new WebDriverWait(driver, tOut);
		element = driver.findElement(toDefineElement(type, value));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/*
	 * Get_Web_Grid
	 */
	public static List<WebElement> toGetWebGrid(String type, String value) {
		element = driver.findElement(toDefineElement(type, value));
		List<WebElement> allCell = new ArrayList<WebElement>();
		List<WebElement> allRow = null;
		List<WebElement> rows = (List<WebElement>) element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			allRow =row.findElements(By.tagName("td"));
			for (WebElement e : allRow){
				allCell.add(e);
			}
		}
		return allCell;
	}

	/*
	 * Get_Drop_Down_List
	 */
	public static List<WebElement> toGetDropDownList(String value) {
		element = driver.findElement(By.xpath(value));
		List<WebElement> allValue = (List<WebElement>) element.findElements(By.tagName("option"));
		return allValue;
	}

	/*
	 * Open Firefox and handle here
	 */

	/*
	 * Press_Left_Mouse
	 */
	public static void toPressLeftMouse(String type, String value) {
		actions.clickAndHold(driver.findElement(toDefineElement(type, value))).perform();
	}

	/*
	 * Release_Mouse
	 */
	public static void toReleaseMouse(String type, String value) {
		actions.moveToElement(driver.findElement(toDefineElement(type, value))).release().perform();
	}

	/*
	 * Resize Window
	 */
	public static void toResizeWindown() {
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
	}

	/*
	 * Maximize Window
	 */
	public static void toMaximizeWindow() {
		driver.manage().window().maximize();
	}

	/*
	 * Minimize Window
	 */
	public static void toMinimizeWindow() {
		driver.manage().window().setPosition(new Point(-2000, 0));
	}

	/*
	 * Give focus to current window
	 */
	public static void toGiveFocusToCurrentWindow() {
		actions.release();
	}

	/*
	 * Move
	 */
	public static void toMoveTheFocusToElement(String type, String value) {
		element = driver.findElement(toDefineElement(type, value));
		Point location = element.getLocation();
		actions.moveToElement(element, location.x, location.y).click().perform();
	}

	public static void toShowPopUp(String windowId) {

	}

	public static void toOpenPopUpWithUrl(String url, String windowId) {

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
