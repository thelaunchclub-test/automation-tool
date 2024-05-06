package com.extent.reports.test.log.impl;

import com.aventstack.extentreports.ExtentTest;
import com.extent.reports.test.ReportTest;
import com.extent.reports.test.log.service.Log;
import com.extent.reports.test.status.Status;

/**
 * Provides an implementation of the {@code Log} interface, encapsulating
 * the behavior and state management of logging operations within the application context.
 *
 * <p>
 * This implementation serves as a foundational layer for logging functionalities, offering a basic
 * structure to handle and process logging details based on provided {@code Status} indicators
 * and associated messages.
 * </p>
 *
 * <p>
 * The {@code LogImpl} class delegates the actual logging responsibilities to an underlying
 * {@code Test} instance, which is responsible for managing and persisting the logging information.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>Method {@code log}: Creates a new instance of {@code LogImpl}, facilitating the
 *         initialization of a new logging sequence or context. This method can be extended to
 *         incorporate additional logging configurations or behaviors.</li>
 *     <li>Method {@code setLog}: Delegates the logging operation to an underlying {@code Test} instance,
 *         setting the provided status and details. This method enables the integration of the
 *         {@code LogImpl} with existing logging mechanisms or systems.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     Log logger = new LogImpl();
 *     logger.log(Status.INFO, "Application started successfully.");
 *     logger.setLog(Status.ERROR, "An error occurred during processing.");
 * </pre>
 * </p>
 *
 * <p>
 * Note: This implementation serves as a placeholder and may require additional refinement
 * to incorporate complete logging functionalities, error handling, and integration
 * with external logging systems.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see Log
 * @see ReportTest
 */
public final class LogImpl implements Log {

    private ReportTest test;
    private final ExtentTest extentTest;

    public LogImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log log(final Status status, final String details) {
        return new LogImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLog(final Status status, final String details) {
        test.setLog(status, details);
    }

    @Override
    public void LogInfo(final String message) {
        extentTest.info(message);
    }

    @Override
    public void LogPass(final String message) {
        extentTest.pass(message);
    }

    @Override
    public void LogFail(final String message) {
        extentTest.fail(message);
    }

    @Override
    public void LogSkip(final String message) {
        extentTest.skip(message);
    }

    @Override
    public void LogWarning(final String message) {
        extentTest.warning(message);
    }
}



