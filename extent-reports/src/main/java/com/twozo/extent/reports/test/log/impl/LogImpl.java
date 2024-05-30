package com.twozo.extent.reports.test.log.impl;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.twozo.extent.reports.formatter.Formatter;
import com.twozo.extent.reports.test.ReportTest;
import com.twozo.extent.reports.test.log.service.Log;
import com.twozo.extent.reports.test.status.LogStatus;

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

    private final ExtentTest extentTest;

    public LogImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    /**
     * {@inheritDoc}
     *
     * @param logStatus The status of the log message.
     * @param details  The details or content of the log message.
     */
    @Override
    public void setLog(final LogStatus logStatus, final String details) {
        final Status convertStatus = LogStatus.getStatus(logStatus);

        extentTest.log(convertStatus, details);
    }

    /**
     * {@inheritDoc}
     *
     * @param message The informational message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log info(final String message) {
        extentTest.info(message);

        return this;
    }

    @Override
    public Log info(Formatter markupGenerator) {
        extentTest.info(markupGenerator);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The pass message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log pass(final String message) {
        extentTest.pass(message);

        return this;
    }

    @Override
    public Log pass(Formatter markupGenerator) {
        extentTest.pass(markupGenerator);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The fail message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log fail(final String message) {
        extentTest.fail(message);

        return this;
    }

    @Override
    public Log fail(Formatter markupGenerator) {
        extentTest.fail(markupGenerator);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The skip message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log skip(final String message) {
        extentTest.skip(message);

        return this;
    }

    @Override
    public Log skip(Formatter markupGenerator) {
        extentTest.skip(markupGenerator);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The warn message to be logged.
     * @return The current instance of the Log object, allowing method chaining.
     */
    @Override
    public Log warn(final String message) {
        extentTest.warning(message);

        return this;
    }

    @Override
    public Log warn(Formatter markupGenerator) {
        extentTest.warning(markupGenerator);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param exception The exception that caused the test failure.
     */
    @Override
    public void fail(final Exception exception) {
        extentTest.fail(exception);
    }
}