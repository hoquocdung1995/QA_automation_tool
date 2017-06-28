package com.csc.fixture;

import org.apache.log4j.Logger;


public class InteractWebApplication {
	private static org.apache.log4j.Logger log = Logger.getLogger(InteractWebApplication.class);
	public InteractWebApplication() {
		log.info("InteractWebApplication()");
	}

	public void iNavigateToPage(String url) {
		log.info("iNavigateToPage: ");
	}

	public void iClickTheElement(String locator) {
		log.info("iClickTheElement: ");
	}

	public void iShouldSeeThePopupAppears(String windowId) {
		log.info("iShouldSeeThePopupAppears: ");
	}
	
	public void iOpenThePopupWindowWith(String url, String windowId) {
		log.info("iOpenThePopupWindowWith: ");
	}
	
	public void iCloseTheBrowser(){
		log.info("iCloseTheBrowser: ");
	}
	
	public void iDoubleClickTheElement(String locator){
		log.info("iDoubleClickTheElement: ");
	}
	
	public void iDragTheElementAndDropToTheElement(String locator1, String locator2){
		log.info("iDragTheElementAndDropToTheElement: ");
	}
	
	public void iMoveTheFocusToTheElement(String locator){
		log.info("iMoveTheFocusToTheElement: ");
	}
	
	public void iPressTheLeftMouseButtonOnTheElement(String locator){
		log.info("iPressTheLeftMouseButtonOnTheElement: ");
	}

	public void iReleaseTheLeftMouseButtonOnTheElement(String locator){
		log.info("iReleaseTheLeftMouseButtonOnTheElement: ");
	}
	
	public void iPause(String waitTime){
		log.info("iPause: ");
	}
	
	public void iRefresh(){
		log.info("iRefresh: ");
	}
	
	public void iSelectTheOptionFromADropDown(String optionLocator, String selectLocator){
		log.info("iSelectTheOptionFromADropDown: ");
	}
	
	public void iSelectTheWindow(String windowId){
		log.info("iSelectTheWindow: ");
	}
	
	public void iSetTheInputWithValue(String locator, String value){
		log.info("iSetTheInputWithValue: ");
	}

	public void iWaitForANewPageToLoad(String timeOut){
		log.info("iWaitForANewPageToLoad: ");
	}
	
	public void iGiveFocusToTheCurrentlySelectedWindow(){
		log.info("iGiveFocusToTheCurrentlySelectedWindow: ");
	}
	
	public void iExecuteJavascriptOnElement(String script, String locator){
		log.info("iExecuteJavaScriptOnElement: ");
	}
	
	public void iResizeCurrentlySelectedWindowToTakeUpTheEntireScreen(){
		log.info("iResizeCurrentlySelectedWindowToTakeUpTheEntireScreen: ");
	}
	
	
}
