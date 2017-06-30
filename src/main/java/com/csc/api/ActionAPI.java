package com.csc.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.csc.driverpool.Driver;
import com.csc.driverpool.DriverPool;

import java.io.File;

public class ActionAPI {
//	static{
//		File file = new File("D://QA_automation_tool//chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//	}
	
	//ChromeDriver driver = Driver.getDriver();
	
	WebDriver driver = Driver.getDriver();
//	WebDriver driver = dr.open();
//	FirefoxDriver driver = (FirefoxDriver) Driver.open();
	
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
		
	}
	public void toDoubleClick(String type,String value){
		
	}
	public void toSelectDropdownList(String type,String value,String type2,String value2){
		
	}
	public void toSelectOption(String type,String value,String input){
		
	}
	public void toExcuteJavascript(String type,String value,String script){
		
	}
	public void toDragAndDrop(String type1,String value1,String type2,String value2){
		
	}
	public void toRefresh(){
		
	}
	public String toGetElementText(String type,String value){
		
		return "";
	}
	public void toPause(String waitTime){
		
	}
	public void toWaitforProperty(String timeOut){
				
	}
	public void toPressLeftMouse(String type,String value){
		
	}
	public void toReleaseMouse(String type,String value){
		
	}
	public void toResizeWindown(){
		
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
