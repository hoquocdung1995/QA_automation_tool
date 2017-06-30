package com.csc.javafresher.qaautomationtool;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.csc.fixture.InteractWebApplication;

import com.csc.storage.MyLog;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	InteractWebApplication app = new InteractWebApplication();
        app.iNavigateToPage("https://github.com");
      //  app.setName("locator.properties");
        app.iClickTheElement("gitSignUp");
        app.iSetTheInputWithValue("userName", "Tuyendt");
        app.iSetTheInputWithValue("email", "tuyendt@gmail.com");
        app.iSetTheInputWithValue("password", "tuyendt123");
//        MyLog.info("ejfweklfjwelkjl");
    }
	
	 
}
