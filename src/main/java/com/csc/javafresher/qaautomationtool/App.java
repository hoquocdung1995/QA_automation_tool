package com.csc.javafresher.qaautomationtool;


import com.csc.fixture.InteractWebApplication;
import com.csc.fixture.SetUpConfiguration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	SetUpConfiguration config = new SetUpConfiguration();
    	config.setDriverPath("D:/finalProjectFitnesse/");
    	config.setFileConfig("locator.properties");
    	config.setTestSlaveMachine("http://20.203.139.10:4444/wd/hub");
    	config.setUrl("C:/FileProperties");
    	
    	
    	InteractWebApplication app = new InteractWebApplication();
    	app.iOpenBrowserAndNameIt("Firefox", "firefox1");
        app.iNavigateToPage("https://github.com");
        app.iClickTheElement("gitSignUp");
        app.iSetTheInputWithValue("userName", "Tuyendt");
        app.iSetTheInputWithValue("email", "tuyendt@gmail.com");
        app.iSetTheInputWithValue("password", "tuyendt123");
        app.iClickTheElement("submit");
        

    }
	
	 
}
