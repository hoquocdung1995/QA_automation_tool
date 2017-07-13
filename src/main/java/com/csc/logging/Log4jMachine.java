package com.csc.logging;

import org.apache.log4j.Logger;

/**
 * 
 * @author Nguyen Huu Phuoc
 * log4j object of observer
 */
public class Log4jMachine extends Observer {
	private static org.apache.log4j.Logger log = Logger.getLogger(Log4jMachine.class);

	@Override
	public void executeLoggingInfo(String message) {
		log.info(message);
	}

	@Override
	public void executeLoggingError(String message) {
		log.error(message);
	}

	@Override
	public void executeLoggingWarn(String message) {
		log.warn(message);
	}

	@Override
	public void executeLoggingDebug(String message) {
		log.debug(message);
	}

	@Override
	public void executeLoggingFatal(String message) {
		log.fatal(message);
	}

	@Override
	public void executeLoggingTrace(String message) {
		log.trace(message);
	}
}
