package com.csc.logging;

import java.util.ArrayList;

/**
 * 
 * @author Nguyen Huu Phuoc
 * The object can manage and notify
 */
public class SystemLogging {
	//list objects of object observer
	private static ArrayList<Observer> observers = new ArrayList<Observer>();
	//add object to list
	public static void registerLoggingObserver(Observer obs) {
		observers.add(obs);
	}
	//remove object to list
	public static void removeLoggingObserver(Observer obs) {
		observers.remove(obs);
	}

	// info
	public static void info(String message) {
		notifyAllLoggingInfo(message);
	}
	//notify to list of Observer object
	private static void notifyAllLoggingInfo(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingInfo(message);
		}
	}

	// error
	public static void error(String message) {
		notifyAllLoggingError(message);
	}
	//notify to list of Observer object
	private static void notifyAllLoggingError(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingError(message);
		}
	}

	// warn
	public static void warn(String message) {
		notifyAllLoggingWarn(message);
	}
	//notify to list of Observer object
	private static void notifyAllLoggingWarn(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingWarn(message);
		}
	}

	// debug
	public static void debug(String message) {
		notifyAllLoggingDebug(message);
	}
	//notify to list of Observer object
	private static void notifyAllLoggingDebug(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingDebug(message);
		}
	}

	// fatal
	public static void fatal(String message) {
		notifyAllLoggingFatal(message);
	}
	//notify to list of Observer object
	private static void notifyAllLoggingFatal(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingFatal(message);
		}
	}

	// trace
	public static void trace(String message) {
		notifyAllLoggingTrace(message);
	}
	//notify to list of Observer object
	private static void notifyAllLoggingTrace(String message) {
		for (Observer obs : observers) {
			obs.executeLoggingTrace(message);
		}
	}

}
