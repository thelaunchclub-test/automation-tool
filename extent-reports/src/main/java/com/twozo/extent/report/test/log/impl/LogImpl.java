package com.twozo.extent.report.test.log.impl;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.twozo.extent.report.test.formatter.Formatter;
import com.twozo.extent.report.test.ReportTest;
import com.twozo.extent.report.test.log.Log;
import com.twozo.extent.report.test.status.LogStatus;

/**
 * Represents a log entry for a {@link ReportTest}.
 *
 * <p>
 * Designed to manage the details of test execution logs.Provides access to the status of the test, the message
 * logged during the test, and the name of the test itself.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * log.setLog(Status.PASSED, "Test completed successfully.");
 * }</pre>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see Log
 */
public final class LogImpl implements Log {

    private final ExtentTest extentTest;

    public LogImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    /**
     * {@inheritDoc}
     *
     * @param logStatus  - the {@link LogStatus}.
     * @param logMessage - the message to be logged.
     */
    @Override
    public void setLog(final LogStatus logStatus, final String logMessage) {
        final Status convertStatus = LogStatus.getStatus(logStatus);

        extentTest.log(convertStatus, logMessage);
    }

    /**
     * {@inheritDoc}
     *
     * @param message The message to be logged.
     * @return The {@link Log}.
     */
    @Override
    public Log info(final String message) {
        extentTest.info(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param formatter The {@link Formatter}.
     * @return The {@link Log}.
     */
    @Override
    public Log info(final Formatter formatter) {
        extentTest.info(formatter);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The pass message to be logged.
     * @return The {@link Log}.
     */
    @Override
    public Log pass(final String message) {
        extentTest.pass(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param formatter The {@link Formatter}.
     * @return The {@link Log}.
     */
    @Override
    public Log pass(final Formatter formatter) {
        extentTest.pass(formatter);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The fail message to be logged.
     * @return The {@link Log}.
     */
    @Override
    public Log fail(final String message) {
        extentTest.fail(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param formatter The {@link Formatter}.
     * @return The {@link Log}.
     */
    @Override
    public Log fail(final Formatter formatter) {
        extentTest.fail(formatter);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The skip message to be logged.
     * @return The {@link Log}.
     */
    @Override
    public Log skip(final String message) {
        extentTest.skip(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param formatter The {@link Formatter}.
     * @return The {@link Log}.
     */
    @Override
    public Log skip(final Formatter formatter) {
        extentTest.skip(formatter);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param message The warn message to be logged.
     * @return The {@link Log}.
     */
    @Override
    public Log warn(final String message) {
        extentTest.warning(message);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param formatter The {@link Formatter}.
     * @return The {@link Log}.
     */
    @Override
    public Log warn(final Formatter formatter) {
        extentTest.warning(formatter);

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