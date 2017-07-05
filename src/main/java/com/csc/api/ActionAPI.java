package com.csc.api;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.csc.action.PageAction;
import com.csc.driverpool.DriverPool;
import com.csc.fixture.SetUpConfiguration;

public class ActionAPI {

	private Select select;

	static WebDriver driver = DriverPool.getDriverPool();
	Actions actions = new Actions(driver);
	private WebElement element;

	public static String verifyElementText(String locator) {
		PageAction action = new PageAction();
		List<String> loca = action.readLocator(locator);
		String type = loca.get(0);
		String elementText = "";
		try {
			if (type.equals("xpath")) {
				elementText = driver.findElement(By.xpath(loca.get(1))).getText();
			} else if (type.equals("id")) {
				elementText = driver.findElement(By.id(loca.get(1))).getText();
			} else if (type.equals("name")) {
				elementText = driver.findElement(By.name(loca.get(1))).getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			elementText = "Not found";
		}

		return elementText;

	}

	// navigate
	public void toNavigate(String url) {
		System.out.println("I navigate");
		driver.navigate().to(url);
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

	// Click element
	public void toClick(String type, String value) throws InterruptedException {
		if ("id".equals(type))
			driver.findElement(By.id(value)).click();
		else if ("name".equals(type))
			driver.findElement(By.name(value)).click();
		else if ("xpath".equals(type)){
			driver.findElement(By.xpath((value))).click();
		}
		
	}

	// set Input for element
	public void toSetInput(String type, String value, String input) {
		if ("id".equals(type))
			driver.findElement(By.id(value)).sendKeys(input);
		else if ("name".equals(type))
			driver.findElement(By.name(value)).sendKeys(input);
		else if ("xpath".equals(type))
			driver.findElement(By.xpath((value))).sendKeys(input);
	}

	// close browser
	public void toCloseBrowser() {
		driver.close();
	}

	// Double click element
	public void toDoubleClick(String type, String value) {
		if ("id".equals(type))
			actions.doubleClick(driver.findElement(By.id(value))).perform();
		else if ("name".equals(type))
			actions.doubleClick(driver.findElement(By.name(value))).perform();
		else if ("xpath".equals(type))
			actions.doubleClick(driver.findElement(By.xpath(value))).perform();
		;
	}

	// Select Option from drop down list
	public void toSelectDropdownList(String type, String value, String input) {
		if (type.equalsIgnoreCase("id")) {
			select = new Select(driver.findElement(By.id(value)));
			select.selectByVisibleText(input);
		} else if (type.equalsIgnoreCase("name")) {
			select = new Select(driver.findElement(By.name(value)));
			select.selectByVisibleText(input);
		} else if (type.equalsIgnoreCase("xpath")) {
			select = new Select(driver.findElement(By.xpath(value)));
			select.selectByVisibleText(input);
		}
	}

	// Select_Option//Use_only_NameAttribute
	public void toSelectOption(String value, String input) {
		List<WebElement> e = driver.findElements(By.name(value));
		for (int i = 0; i < e.size(); i++) {
			if ((e.get(i).getAttribute("value").equals(input))) {
				e.get(i).click();
			}
		}
	}

	// Excute Javascript
	public void toExcuteJavascript(String script, String type, String value) {
			if (type.toLowerCase().equals("id") && driver instanceof JavascriptExecutor) {
				driver.findElement(By.id(value));
				((JavascriptExecutor) driver).executeScript(script);
			} else if (type.toLowerCase().equals("name") && driver instanceof JavascriptExecutor) {
				driver.findElement(By.name(value));
				((JavascriptExecutor) driver).executeScript(script);
			} else if (type.toLowerCase().equals("xpath") && driver instanceof JavascriptExecutor) {
				driver.findElement(By.xpath(value));
				((JavascriptExecutor) driver).executeScript(script);
			}
	}

	// Drag and drop
	public void toDragAndDrop(String type1, String value1, String type2, String value2) {
		if ("id".equals(type1)) {
			if ("id".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.id(value1)), driver.findElement(By.id(value2))).perform();
			} else if ("name".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.id(value1)), driver.findElement(By.name(value2))).perform();
			} else if ("xpath".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.id(value1)), driver.findElement(By.xpath(value2))).perform();
			}

		} else if ("name".equals(type1)) {
			if ("id".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.name(value1)), driver.findElement(By.id(value2))).perform();
			} else if ("name".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.name(value1)), driver.findElement(By.name(value2))).perform();
			} else if ("xpath".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.name(value1)), driver.findElement(By.xpath(value2)))
						.perform();
			}
		}

		else if ("xpath".equals(type1)) {
			if ("id".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.xpath(value1)), driver.findElement(By.id(value2))).perform();
			} else if ("name".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.xpath(value1)), driver.findElement(By.name(value2)))
						.perform();
			} else if ("xpath".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.xpath(value1)), driver.findElement(By.xpath(value2)))
						.perform();
			}
		}
	}

	// Refresh page
	public void toRefresh() {
		driver.navigate().refresh();
	}

	// Get Element text (by element attribute)
	public String toGetElementText(String type, String value) {
		if (type.toLowerCase().equals("id")) {
			element = driver.findElement(By.id(value));
		} else if (type.toLowerCase().equals("name")) {
			element = driver.findElement(By.name(value));
		} else if ((type.toLowerCase().equals("classname")) || (type.toLowerCase().equals("class"))) {
			element = driver.findElement(By.className(value));
		} else if ((type.toLowerCase().equals("tagname")) || (type.toLowerCase().equals("tag"))) {
			element = driver.findElement(By.tagName(value));
		} else if ((type.toLowerCase().equals("linktext")) || (type.toLowerCase().equals("link"))) {
			element = driver.findElement(By.linkText(value));
		} else if (type.toLowerCase().equals("partiallinktext")) {
			element = driver.findElement(By.partialLinkText(value));
		} else if ((type.toLowerCase().equals("cssselector")) || (type.toLowerCase().equals("css"))) {
			element = driver.findElement(By.cssSelector(value));
		} else if (type.toLowerCase().equals("xpath")) {
			element = driver.findElement(By.xpath(value));
		}
		return element.getAttribute("value");
	}

	public void toPause(String waitTime) {
		try {
			int time = Integer.valueOf(waitTime);
			Thread.sleep((time));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Wait_For_Property
	public void toWaitforProperty(String type, String value, String timeOut) {
		int tOut = Integer.parseInt(timeOut); 
		if (type.equalsIgnoreCase("id")) {			
			WebDriverWait wait = new WebDriverWait(driver, tOut);
			element = driver.findElement(By.id(value));
		    wait.until(ExpectedConditions.visibilityOf(element));
		} else if (type.equalsIgnoreCase("name")) {
			WebDriverWait wait = new WebDriverWait(driver, tOut);
			element = driver.findElement(By.name(value));
			wait.until(ExpectedConditions.visibilityOf(element));
		} else if (type.equalsIgnoreCase("xpath")) {
			WebDriverWait wait = new WebDriverWait(driver, tOut);
			element = driver.findElement(By.xpath(value));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	// Get_Web_Grid
	public ArrayList<WebElement> toGetWebGrid(String value) {
		element = driver.findElement(By.xpath(value));
		ArrayList<WebElement> allCell = null;
		ArrayList<WebElement> rows = (ArrayList<WebElement>) element.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			allCell = (ArrayList<WebElement>) row.findElements(By.tagName("//td"));
		}
		return allCell;
	}

	// Get_Drop_Down_List
	public List<WebElement> toGetDropDownList(String value) {
		element = driver.findElement(By.xpath(value));
		List<WebElement> allValue = (List<WebElement>) element.findElements(By.tagName("option"));
		return allValue;
	}

	// Prees_Left_Mouse
	public void toPressLeftMouse(String type, String value) {
		if ("id".equals(type))
			actions.clickAndHold(driver.findElement(By.id(value))).perform();
		else if ("name".equals(type))
			actions.clickAndHold(driver.findElement(By.name(value))).perform();
		else if ("xpath".equals(type))
			actions.clickAndHold(driver.findElement(By.xpath(value))).perform();
	}

	// Release_Mouse
	public void toReleaseMouse(String type, String value) {
		if ("id".equals(type))
			actions.release(driver.findElement(By.id(value))).perform();
		else if ("name".equals(type))
			actions.release(driver.findElement(By.name(value))).perform();
		else if ("xpath".equals(type))
			actions.release(driver.findElement(By.xpath(value))).perform();
	}

	public void toResizeWindown() {
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
	}

	public void toMaximizeWindow() {
		driver.manage().window().maximize();
	}

	public void toMinimizeWindow() {
		driver.manage().window().setPosition(new Point(-2000, 0));
	}

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

	public void toShowPopUp(String windownId) {

	}

	public void toOpenPopUpWithUrl(String url, String windowId) {

	}

	public void toGiveFocusToCurrentWindow() {

	}

	public void toMoveTheFocusToElement(String string, String string2) {

	}

}
