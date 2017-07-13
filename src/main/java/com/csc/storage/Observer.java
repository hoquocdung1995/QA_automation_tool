package com.csc.storage;

/**
 * 
 * @author Nguyen Huu Phuoc
 *
 */
public abstract class Observer {
	protected SystemLogging systemLogging;

	public abstract void executeLoggingInfo(String message);

	public abstract void executeLoggingError(String message);

	public abstract void executeLoggingWarn(String message);

	public abstract void executeLoggingDebug(String message);

	public abstract void executeLoggingFatal(String message);

	public abstract void executeLoggingTrace(String message);
}
