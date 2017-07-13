package com.csc.javafresher.qaautomationtool;


import com.csc.fixture.InteractWebApplication;
import com.csc.storage.Log4jMachine;
import com.csc.storage.SystemLogging;


/**
 * Hello world!
 *
 */
public class App 
{
	public static Log4jMachine log4j = new Log4jMachine();
	public static void testLog(){
		SystemLogging.registerLoggingObserver(log4j);
		SystemLogging.info("hello");
		SystemLogging.error("zzz");
		SystemLogging.debug("zzz");
		SystemLogging.fatal("zzz");
		SystemLogging.trace("zzz");
		SystemLogging.warn("zzz");
	}
    public static void main( String[] args ) throws InterruptedException
    {
    	testLog();
//    	InteractWebApplication app = new InteractWebApplication();    	
//        app.iNavigateToPage("https://github.com");
//        app.iClickTheElement("gitSignUp");
//        app.iSetTheInputWithValue("userName", "Tuyendt");
//        app.iSetTheInputWithValue("email", "tuyendt@gmail.com");
//        app.iSetTheInputWithValue("password", "tuyendt123");
//        app.iClickTheElement("submit");
        

    }
	
	 
}
