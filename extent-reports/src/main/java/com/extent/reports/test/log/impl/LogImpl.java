package com.extent.reports.test.log.impl;

import com.aventstack.extentreports.ExtentTest;

import com.extent.reports.test.ReportTest;
import com.extent.reports.test.ReportTestImpl;
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

    private final ReportTest test;
    private final ExtentTest extentTest;

    public LogImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
        this.test = new ReportTestImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @param status  The status of the log message.
     * @param details The details or content of the log message.
     * @return A new Log instance initialized with the provided status and details.
     */
    @Override
    public Log log(final Status status, final String details) {
        return new LogImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @param status  The status of the log message.
     * @param details The details or content of the log message.
     */
    @Override
    public void setLog(final Status status, final String details) {
        test.setLog(status, details);
    }

    /**
     * {@inheritDoc}
     *
     * @param message The informational message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log LogInfo(final String message) {
        extentTest.info(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The pass message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log LogPass(final String message) {
        extentTest.pass(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The fail message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log LogFail(final String message) {
        extentTest.fail(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The skip message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log LogSkip(final String message) {
        extentTest.skip(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The warning message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log LogWarning(final String message) {
        extentTest.warning(message);

        return this;
    }
}