package com.csc.api;

import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.csc.action.PageAction;
import com.csc.driverpool.DriverPool;
import com.csc.driverpool.TestConstant;
import com.csc.fixture.SetUpConfiguration;

public class ActionAPI {

	private static Logger logger = Logger.getLogger(ActionAPI.class);

	private Select select;
	Actions actions;
	static WebDriver driver = DriverPool.createDriverPool();
	private WebElement element;

	public ActionAPI() {
		//driver = DriverPool.createDriverPool();
		this.actions = new Actions(driver);
	}

	/*
	 * Define Element id, name, x_path, tag name
	 */
	public By toDefineElement(String type, String value) {
		By by = null;
		if (TestConstant.xpath.equalsIgnoreCase(type)) {
			by = By.xpath(value);
		} else if (TestConstant.name.equalsIgnoreCase(type)) {
			by = By.name(value);
		} else if (TestConstant.id.equalsIgnoreCase(type)) {
			by = By.id(value);
		} else if (TestConstant.cssSelector.equalsIgnoreCase(type) || TestConstant.css.equalsIgnoreCase(type)) {
			by = By.cssSelector(value);
		} else if (TestConstant.tagName.equalsIgnoreCase(type) || TestConstant.tag.equalsIgnoreCase(type)) {
			by = By.cssSelector(value);
		}
		return by;
	}

	/*
	 * Verify WebElement
	 */
	public static String verifyElementText(String locator) {
		PageAction action = new PageAction();
		List<String> locators = action.readLocator(locator);
		String type = locators.get(0);
		String elementText = "";
		try {
			if (TestConstant.xpath.equalsIgnoreCase(type)) {
				elementText = driver.findElement(By.xpath(locators.get(1))).getText();
			} else if (TestConstant.name.equalsIgnoreCase(type)) {
				elementText = driver.findElement(By.name(locators.get(1))).getText();
			} else if (TestConstant.id.equalsIgnoreCase(type)) {
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
	public void toNavigate(String url) {
		logger.debug("I navigate");
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	/*
	 * Click
	 */
	public void toClick(String type, String value) throws InterruptedException {
		driver.findElement(toDefineElement(type, value)).click();
	}

	/*
	 * set Input for element
	 */
	public void toSetInput(String type, String value, String input) {
		driver.findElement(toDefineElement(type, value)).sendKeys(input);
	}

	/*
	 * Close browser
	 */
	public void toCloseBrowser() {
		driver.close();
	}

	/*
	 * Double click element
	 */
	public void toDoubleClick(String type, String value) {
		actions.doubleClick(driver.findElement(toDefineElement(type, value))).perform();
	}

	/*
	 * Define Element is present or not
	 */
	public boolean isElementIsPresent(String type, String value) {
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
	public void toSelectDropdownList(String type, String value, String input) {
		select = new Select(driver.findElement(toDefineElement(type, value)));
		select.selectByVisibleText(input);
	}

	/*
	 * Select_Option//Use_only_NameAttribute
	 */
	public void toSelectOption(String value, String input) {
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
	public void toExcuteJavascript(String script, String type, String value) {
		if (driver instanceof JavascriptExecutor) {
			driver.findElement(toDefineElement(type, value));
			((JavascriptExecutor) driver).executeScript(script);
		}
	}

	/*
	 * Drag and drop
	 */
	public void toDragAndDrop(String type1, String value1, String type2, String value2) {
		actions.dragAndDrop(driver.findElement(toDefineElement(type1, value1)),
				driver.findElement(toDefineElement(type2, value2))).perform();
	}

	/*
	 * Refresh page
	 */
	public void toRefresh() {
		driver.navigate().refresh();
	}

	/*
	 * Get Element text (by element attribute)
	 */
	public String toGetElementText(String type, String value) {
		element = driver.findElement(toDefineElement(type, value));
		return element.getAttribute("value");
	}

	/*
	 * Pause (sleep with wait time)
	 */
	public void toPause(String waitTime) {
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
	public void toWaitforProperty(String type, String value, String timeOut) {
		int tOut = Integer.parseInt(timeOut);
		WebDriverWait wait = new WebDriverWait(driver, tOut);
		element = driver.findElement(toDefineElement(type, value));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/*
	 * Get_Web_Grid
	 */
	public ArrayList<WebElement> toGetWebGrid(String value) {
		element = driver.findElement(By.xpath(value));
		ArrayList<WebElement> allCell = null;
		ArrayList<WebElement> rows = (ArrayList<WebElement>) element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			allCell = (ArrayList<WebElement>) row.findElements(By.tagName("//td"));
		}
		return allCell;
	}

	/*
	 * Get_Drop_Down_List
	 */
	public List<WebElement> toGetDropDownList(String value) {
		element = driver.findElement(By.xpath(value));
		List<WebElement> allValue = (List<WebElement>) element.findElements(By.tagName("option"));
		return allValue;
	}

	/*
	 * Open Firefox and handle here
	 */
	public void openFirefox() {

		try {
			String ip = SetUpConfiguration.configuration.getTestSlaveMachine();
			driver = new RemoteWebDriver(new URL(ip), DesiredCapabilities.firefox());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> allHandles = driver.getWindowHandles();
		System.out.println("Count of windows:" + allHandles.size());
		allHandles.remove(allHandles.iterator().next());
		// get the last Window Handle
		String lastHandle = allHandles.iterator().next();
		driver.switchTo().window(lastHandle);
	}

	/*
	 * Open Chrome and handle here
	 */
	public void openChrome() {
		try {
			String ip = SetUpConfiguration.configuration.getTestSlaveMachine();
			driver = new RemoteWebDriver(new URL(ip), DesiredCapabilities.chrome());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> allHandles = driver.getWindowHandles();
		System.out.println("Count of windows:" + allHandles.size());
		allHandles.remove(allHandles.iterator().next());
		// get the last Window Handle
		String lastHandle = allHandles.iterator().next();
		driver.switchTo().window(lastHandle);
	}

	/*
	 * Press_Left_Mouse
	 */
	public void toPressLeftMouse(String type, String value) {
		actions.clickAndHold(driver.findElement(toDefineElement(type, value))).perform();
	}

	public void toMoveMouse(String type, String value){
		actions.moveToElement(driver.findElement(toDefineElement(type, value))).perform();
	}
	/*
	 * Release_Mouse
	 */
	public void toReleaseMouse(String type, String value) {
		actions.release(driver.findElement(toDefineElement(type, value))).perform();
	}
	
	/*
	 * Resize Window
	 */
	public void toResizeWindown() {
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
	}
	/*
	 * Maximize Window
	 */
	public void toMaximizeWindow() {
		driver.manage().window().maximize();
	}
	/*
	 * Minimize Window
	 */
	public void toMinimizeWindow() {
		driver.manage().window().setPosition(new Point(-2000, 0));
	}

	/*
	 * Give focus to current window
	 */
	public void toGiveFocusToCurrentWindow() {
		actions.release();
	}
	/*
	 * Move 
	 */
	public void toMoveTheFocusToElement(String type, String value) {
		element = driver.findElement(toDefineElement(type, value));  
		Point location = element.getLocation();  
		actions.moveToElement(element, location.x, location.y).click().perform();
	}
	
	public void toShowPopUp(String windowId) {

	}

	public void toOpenPopUpWithUrl(String url, String windowId) {

	}
	

}
