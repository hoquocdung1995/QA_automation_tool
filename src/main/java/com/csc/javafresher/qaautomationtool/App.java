package com.csc.javafresher.qaautomationtool;


import com.csc.PaseVerifications.Verification;
import com.csc.fixture.InteractWebApplication;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	InteractWebApplication app = new InteractWebApplication();
    	Verification ver = new Verification();
    	
        app.iNavigateToPage("https://github.com");
        app.iClickTheElement("gitSignUp");
        app.iSetTheInputWithValue("userName", "Tuyendt");
        app.iSetTheInputWithValue("email", "tuyendt@gmail.com");
        app.iSetTheInputWithValue("password", "tuyendt123");
        app.iClickTheElement("submit");
        
        
        ver.verifyElementText("success");
    }
	
	 
}
