package com.csc.exception;

import com.csc.logging.Log4jMachine;
import com.csc.logging.SystemLogging;
import com.csc.storage.Screenshot;
/**
 * Fixture Exception
 * @author Vo Duong Quang
 *
 */
public class FixtureException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public static Log4jMachine log4j = new Log4jMachine();

	public FixtureException(Throwable e) {
		super(createMessage(), e);
		SystemLogging.registerLoggingObserver(log4j);
		SystemLogging.error(e.getMessage());
	}
	/**
	 * @return URl image screenshot
	 */
	public static String createMessage() {
		String msg = "URL of screenshot: " + Screenshot.screenshot();
		return msg;
	}
}
