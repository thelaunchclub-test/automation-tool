package com.twozo.extent.report.reporter.logger;

import com.aventstack.extentreports.ExtentTest;
import com.twozo.extent.report.test.model.LogStatus;

/**
 * Wraps ExtentReports logging functionality for test results (pass, fail, skip, info).
 * Supports thread-safe logging using ThreadLocal to store ExtentTest instances for individual threads.
 *
 * @author Navin Jones
 * @version 1.0
 */
public final class ExtentLogger {

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private ExtentLogger() {

    }

    /**
     * Retrieves the singleton instance of ExtentLogger.
     *
     * @return The singleton instance of ExtentLogger.
     */
    public static ExtentLogger getInstance() {
        return ExtentLoggerInstance.INSTANCE;
    }

    /**
     * Private static class responsible for holding the singleton instance of ExtentLogger.
     * This ensures that the instance is created only when it is accessed for the first time (lazy initialization).
     */
    private static class ExtentLoggerInstance {
        private static final ExtentLogger INSTANCE = new ExtentLogger();
    }

    /**
     * Generic logging method that logs messages with different statuses (PASS, FAIL, SKIP, INFO).
     * This reduces redundancy by consolidating common logging logic into one method.
     *
     * @param status  The status of the log (PASS, FAIL, SKIP, INFO).
     * @param message The message to log.
     */
    public static void log(LogStatus status, final String message) {
        ExtentManager.getReportTest(extentTest.get()).getLog().setLog(status, message);
    }

    /**
     * Logs a "PASS" message to the extent report.
     *
     * @param message The pass message to log.
     */
    public static void pass(final String message) {
        log(LogStatus.PASS, message);
    }

    /**
     * Logs a "FAIL" message to the extent report.
     *
     * @param message The fail message to log.
     */
    public static void fail(final String message) {
        log(LogStatus.FAIL, message);
    }

    /**
     * Logs a "SKIP" message to the extent report.
     *
     * @param message The skip message to log.
     */
    public static void skip(final String message) {
        log(LogStatus.SKIP, message);
    }

    /**
     * Logs an "INFO" message to the extent report.
     *
     * @param message The info message to log.
     */
    public static void info(final String message) {
        log(LogStatus.INFO, message);
    }

    /**
     * Sets the ExtentTest instance for the current thread.
     * This method is called before the test execution to ensure the thread is associated with the correct ExtentTest.
     *
     * @param test The ExtentTest instance to be associated with the current thread.
     */
    public static void setExtentTest(final ExtentTest test) {
        extentTest.set(test);
    }

    /**
     * Retrieves the ExtentTest instance for the current thread.
     *
     * @return The ExtentTest instance associated with the current thread.
     */
    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    /**
     * Removes the ExtentTest instance from the current thread.
     * This is a cleanup method that should be called when the thread is finished to avoid memory leaks.
     */
    public static void removeExtentTest() {
        extentTest.remove();
    }
}