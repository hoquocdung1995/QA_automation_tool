package com.csc.logging;

/**
 * 
 * @author Nguyen Huu Phuoc
 * Abstract class observe and notifies any changes
 */
public abstract class Observer {
	//Object manage and notify 
	protected SystemLogging systemLogging;

	public abstract void executeLoggingInfo(String message);

	public abstract void executeLoggingError(String message);

	public abstract void executeLoggingWarn(String message);

	public abstract void executeLoggingDebug(String message);

	public abstract void executeLoggingFatal(String message);

	public abstract void executeLoggingTrace(String message);
}
