package com.extent.reports.test.log.service;

import com.extent.reports.test.status.Status;

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
 * @see Status
 */
public interface Log {

    /**
     * Logs the given status and details, encapsulating the behavior and state of the logging operation.
     *
     * @param status  - the {@code Status} enum value indicating the log status.
     * @param details - the details or message to be logged, providing context to the logged event.
     * @return an updated instance of the {@code Log} interface, facilitating method chaining and
     *         fluent logging sequences.
     */
    Log log(final Status status, final String details);

    /**
     * Sets the log status and details, representing a standalone logging operation.
     *
     * @param status  - the {@code Status} enum value indicating the log status.
     * @param details - the details or message to be logged, providing context to the logged event.
     */
    void setLog(final Status status, final String details);

    void LogInfo(final String message);

    void LogPass(final String message);

    void LogFail(final String message);

    void LogSkip(final String message);

    void LogWarning(final String message);
}
