package com.csc.storage;

import java.util.ArrayList;

/**
 * 
 * @author Nguyen Huu Phuoc
 *
 */
public class SystemLogging {
	private static ArrayList<Observer> observers = new ArrayList<Observer>();

	public static void registerLoggingObserver(Observer obs) {
		observers.add(obs);
	}

	public static void removeLoggingObserver(Observer obs) {
		observers.remove(obs);
	}

	// info
	public static void info(String message) {
		notifyAllLoggingInfo(message);
	}

	private static void notifyAllLoggingInfo(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingInfo(message);
		}
	}

	// error
	public static void error(String message) {
		notifyAllLoggingError(message);
	}

	private static void notifyAllLoggingError(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingError(message);
		}
	}

	// warn
	public static void warn(String message) {
		notifyAllLoggingWarn(message);
	}

	private static void notifyAllLoggingWarn(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingWarn(message);
		}
	}

	// debug
	public static void debug(String message) {
		notifyAllLoggingDebug(message);
	}

	private static void notifyAllLoggingDebug(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingDebug(message);
		}
	}

	// fatal
	public static void fatal(String message) {
		notifyAllLoggingFatal(message);
	}

	private static void notifyAllLoggingFatal(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingFatal(message);
		}
	}

	// trace
	public static void trace(String message) {
		notifyAllLoggingTrace(message);
	}

	private static void notifyAllLoggingTrace(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingTrace(message);
		}
	}

}
