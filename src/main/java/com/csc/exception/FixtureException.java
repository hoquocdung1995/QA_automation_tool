package com.csc.exception;

import com.csc.storage.Screenshot;
/**
 * Fixture Exception
 * @author Vo Duong Quang
 *
 */
public class FixtureException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FixtureException(Throwable e) {
		super(createMessage(), e);
	}
	/**
	 * @return URl image screenshot
	 */
	public static String createMessage() {
		String msg = "URL of screenshot: " + Screenshot.screenshot();
		return msg;
	}
}
