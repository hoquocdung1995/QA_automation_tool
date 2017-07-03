package com.csc.api;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.csc.driverpool.DriverPool;


public class ActionAPI {

	private Select select;
	
	WebDriver driver = DriverPool.open();
	Actions actions = new Actions(driver);

	public void toNavigate(String url){
		System.out.println("I navigate");
		driver.navigate().to(url);
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	public void toClick(String type,String value) throws InterruptedException{
		System.out.println("I click");
		System.out.println(type);
		System.out.println(value);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		if("id".equals(type))
			driver.findElement(By.id(value)).click();
		else if("name".equals(type))
			driver.findElement(By.name(value)).click();
		else if("xpath".equals(type))
			Thread.sleep(2000);
			driver.findElement(By.xpath((value))).click();
	}
	

	public void toSetInput(String type,String value,String input){
		System.out.println("I set input");
		if("id".equals(type))
			driver.findElement(By.id(value)).sendKeys(input);
		else if("name".equals(type))
			driver.findElement(By.name(value)).sendKeys(input);
		else if("xpath".equals(type))
			driver.findElement(By.xpath((value))).sendKeys(input);
	}
	
	public void toCloseBrowser(){
		driver.close();
	}
	public void toDoubleClick(String type,String value){
		if ("id".equals(type)) 
			actions.doubleClick(driver.findElement(By.id(value))).perform();
		else if ("name".equals(type))
			actions.doubleClick(driver.findElement(By.name(value))).perform();
		else if ("xpath".equals(type))
			actions.doubleClick(driver.findElement(By.xpath(value))).perform();;
	}
	public void toSelectDropdownList(String type,String value,String input){
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
	public void toSelectOption(String type,String value,String input){
		
	}
	public void toExcuteJavascript(String type,String value,String script){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(script);
		}
	}
	public void toDragAndDrop(String type1,String value1,String type2,String value2){
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
				actions.dragAndDrop(driver.findElement(By.name(value1)), driver.findElement(By.xpath(value2))).perform();
			}
		}

		else if ("xpath".equals(type1))
			if ("id".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.xpath(value1)), driver.findElement(By.id(value2))).perform();
			} else if ("name".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.xpath(value1)), driver.findElement(By.name(value2))).perform();
			} else if ("xpath".equals(type2)) {
				actions.dragAndDrop(driver.findElement(By.xpath(value1)), driver.findElement(By.xpath(value2))).perform();
			}
	}
	
	public void toRefresh(){
		driver.navigate().refresh();
	}
	public String toGetElementText(String type,String value){
		
		return "";
	}
	public void toPause(String waitTime){
		try{
			int time = Integer.valueOf(waitTime);
			Thread.sleep((time));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void toWaitforProperty(String timeOut){
				
	}
	public void toPressLeftMouse(String type,String value){
		
	}
	public void toReleaseMouse(String type,String value){
		
	}
	
	public void toResizeWindown(){
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
	}
	
	public void toMaximizeWindow(){
		driver.manage().window().maximize();
	}
	public void toMinimizeWindow(){
		driver.manage().window().setPosition(new Point(-2000, 0));
	}
	
	public void toSwitchToWindow(String windowId){
		
	}
	public void toShowPopUp(String windownId){
		
	}
	public void toOpenPopUpWithUrl(String url,String windowId){
		
	}

	public void toGiveFocusToCurrentWindow() {
		
	}

	public void toMoveTheFocusToElement(String string, String string2) {
		
	}
	
}
