package com.test;

import static org.testng.Assert.fail;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

public final class Log {
	private static final Logger logger = LoggerFactory.getLogger(Log.class.getName());
	private Log() {}
	public static void startTestCase(String testCaseName) {
		logger.debug("----------------------------------------");
		logger.debug("---------- {} ----------", testCaseName);
		logger.debug("----------------------------------------");
	}
	public static void endTestCase(String testCaseName) {
		logger.debug("--------------- ENDING TEST ---------------");
		logger.debug("---------- {} ----------", testCaseName);
		logger.debug("========------------------------========");
	}
	public static void info(String message) {
		logger.info(message);
	}
	public static void warn(String message) {
		logger.warn(message);
	}
	public static void error(String message) {
		logger.error(message);
		fail(message);
	}
	public static void debug(String message) {
		logger.debug(message);
//		logToAppCenter(message);
	}
	public static void info(String message, Object... arguments) {
//		info(formatString(message, arguments));
		logger.info(message, arguments);
	}
	public static void debug(String message, Object... arguments) {
//		debug(formatString(message, arguments));
		logger.debug(message, arguments);
	}
	public static void warn(String message, Object... arguments) {
//		debug(formatString(message, arguments));
		logger.warn(message, arguments);
	}
	public static void error(String message, Object... arguments) {
		error(formatString(message, arguments));
	}
	private static String formatString(String text, Object... objects) {
		return MessageFormatter.arrayFormat(text, objects).getMessage();
	}
	public static void printTestName(String testName) {
    	int testNameLength = testName.length();
        String line = StringUtils.repeat('-', testNameLength + 20);
        Log.info(line);
        Log.info("|         {}         |", testName);
        Log.info(line + "\n");
    }
}
