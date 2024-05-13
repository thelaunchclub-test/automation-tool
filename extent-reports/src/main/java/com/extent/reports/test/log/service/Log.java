package com.extent.reports.test.log.service;

import com.extent.reports.test.status.Statuses;

/**
 * Defines the contract for logging operations within the application.
 * Implementations of this interface encapsulate the behavior and characteristics of various logging strategies.
 *
 * <p>
 * The logging mechanism employs a combination of status indicators and detailed messages to communicate
 * essential information about the application's execution state.
 * </p>
 *
 * <p>
 * Implementing classes are expected to handle the interpretation and persistence of the logging details
 * based on the provided {@code Status} enumeration and corresponding message.
 * </p>
 *
 * <p>
 * This interface supports two primary logging operations:
 * <ul>
 *     <li>{@code log}: A method that logs the provided status and details and returns an updated instance
 *         of the {@code Log} interface, facilitating method chaining and fluent logging sequences.</li>
 *     <li>{@code setLog}: A method that sets the log status and details without returning any value,
 *         suitable for standalone logging operations.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     Log logger = new DefaultLogger();
 *     logger.log(Status.INFO, "Application started successfully.")
 *           .log(Status.ERROR, "An error occurred during processing.");
 * </pre>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see Statuses
 */
public interface Log {

    /**
     * Sets the log status and details, representing a standalone logging operation.
     *
     * @param statuses - the {@code Status} enum value indicating the log status.
     * @param details  - the details or message to be logged, providing context to the logged event.
     */
    void setLog(final Statuses statuses, final String details);

    /**
     * Logs an informational message.
     * This method is used to log informational messages with the Log object.
     *
     * @param message The informational message to be logged.
     */
    Log info(final String message);

    /**
     * Logs a pass message.
     * This method is used to log pass messages with the Log object.
     *
     * @param message The pass message to be logged.
     */
    Log pass(final String message);

    /**
     * Logs a fail message.
     * This method is used to log fail messages with the Log object.
     *
     * @param message The fail message to be logged.
     */
    Log fail(final String message);

    /**
     * Logs a skip message.
     * This method is used to log skip messages with the Log object.
     *
     * @param message The skip message to be logged.
     */
    Log skip(final String message);

    /**
     * Logs a warn message.
     * This method is used to log warn messages with the Log object.
     *
     * @param message The warn message to be logged.
     */
    Log warn(final String message);

    /**
     * Logs a test failure with the provided exception.
     *
     * @param exception The exception that caused the test failure.
     */
    void fail(final Exception exception);
}