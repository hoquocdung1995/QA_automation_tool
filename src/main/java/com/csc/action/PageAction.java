package com.csc.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.csc.api.ActionAPI;
import com.csc.driverpool.DriverPool;
import com.csc.fixture.InteractWebApplication;
import com.csc.fixture.SetUpConfiguration;

public class PageAction {
	private static org.apache.log4j.Logger log = Logger.getLogger(InteractWebApplication.class);

	public static void openNewBrowser(String browserType){
		switch(browserType){
		case "Chrome": 
		 	DriverPool.createDriver("chrome1", "Chrome");
	        ActionAPI.setDriverForAction("chrome1");
			break;
		case "Firefox":
			DriverPool.createDriver("firefox1", "Firefox");
	        ActionAPI.setDriverForAction("firefox1");
			break;
		}
	}
	
	public static void switchToBrowser(String key){
		ActionAPI.setDriverForAction(key);
	}
	
	
	public static void iWaitForMs(String time){
		ActionAPI.toPause(time);
		
	}
	
	public static ArrayList<String> readLocator(String locator)  {
		ArrayList<String> list = null;
		Properties prop = new Properties();
		try {
		    //load a properties file from class path, inside static method
		//	String file = "C:/Users/training//Desktop/FitNesse/FitNesseRoot/bin/locator.properties";
			String filename = SetUpConfiguration.configuration.getUrl() + "/" + SetUpConfiguration.configuration.getFileConfig();
 		    prop.load(new FileInputStream(filename));
 		   
		    String str = prop.getProperty(locator);
		    String[] words =  str.split("=>");
		    String type = words[0];
		    String val = words[1];

		    list = new ArrayList<String>();
		    list.add(type);
		    list.add(val);
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		return list;
	  }
	
	public static ArrayList<String> readLocator2(String locator1,String locator2)  {
		ArrayList<String> list = null;
		Properties prop = new Properties();
		try {
		    //load a properties file from class path, inside static method
			String filename = SetUpConfiguration.configuration.getFileConfig(); 
			prop.load(new FileInputStream(filename));
		    String str = prop.getProperty(locator1);
		    String[] words =  str.split("=>");
		    String type = words[0];
		    String val = words[1];
		    String str2 = prop.getProperty(locator2);
		    String[] words2 =  str2.split("=>");
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
		System.out.println("Page Navigate");
		ActionAPI.toNavigate(url);
	}

	public static void iClickTheElement(String locator) throws InterruptedException {
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toClick(list.get(0), list.get(1));
	}

	public static void iShouldSeeThePopupAppears(String windowId) {
		ActionAPI.toShowPopUp(windowId);
	}
	
	public static void iOpenThePopupWindowWith(String url, String windowId) {
		ActionAPI.toOpenPopUpWithUrl(url, windowId);
	}
	
	public static void iCloseTheBrowser(){
		ActionAPI.toCloseBrowser();
	}
	
	public static void iDoubleClickTheElement(String locator){
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toDoubleClick(list.get(0), list.get(1));
	}
	
	public static void iDragTheElementAndDropToTheElement(String locator1, String locator2){
		ArrayList<String> list = readLocator(locator1);
		ArrayList<String> list2 = readLocator(locator2);
		ActionAPI.toDragAndDrop(list.get(0),list.get(1),list2.get(0),list2.get(2));
	}
	
	public static void iMoveTheFocusToTheElement(String locator){
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toMoveTheFocusToElement(list.get(0), list.get(1));
	}
	
	public static void iPressTheLeftMouseButtonOnTheElement(String locator){
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toPressLeftMouse(list.get(0), list.get(1));
	}

	public static void iReleaseTheLeftMouseButtonOnTheElement(String locator){
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toReleaseMouse(list.get(0), list.get(1));
	}
	
	public static void iPause(String waitTime){
		ActionAPI.toPause(waitTime);
	}
	
	public static void iRefresh(){
		ActionAPI.toRefresh();
	}
	
	public static void iSelectTheOptionFromADropDown(String optionLocator, String input){
		ArrayList<String> list = readLocator(optionLocator);
		ActionAPI.toSelectDropdownList(list.get(0),list.get(1),input);
	}
	
	public static void iSetTheInputWithValue(String locator, String value){
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toSetInput(list.get(0), list.get(1), value);
	}

	public static void iWaitForANewPageToLoad(String type, String value, String timeOut){
		ActionAPI.toWaitforProperty(type, value, timeOut);
	}
	
	public static void iGiveFocusToTheCurrentlySelectedWindow(){
		ActionAPI.toGiveFocusToCurrentWindow();
	}
	
	public static void iExecuteJavascriptOnElement(String script, String locator){
		ArrayList<String> list = readLocator(locator);		
		ActionAPI.toExcuteJavascript(script,list.get(0), list.get(1));
	}
	
	public static void iResizeCurrentlySelectedWindowToTakeUpTheEntireScreen(){
		ActionAPI.toResizeWindown();
	}
	
	public static void switchToWindow(String title) {
		// TODO Auto-generated method stub
		ActionAPI.toSwitchWindow(title);
	}
}