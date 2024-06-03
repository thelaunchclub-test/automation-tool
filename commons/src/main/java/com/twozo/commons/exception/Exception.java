package com.twozo.commons.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * <p>
 * The {@code Exception} is used to manage statuses with associated status codes and custom messages.
 * </p>
 *
 * <p>
 * Provides additional context through custom messages and causes.
 * Ensures a standardized way of handling and reporting issues in the application by associating each status
 * with a specific status code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * // Throwing an INVALID_BASE_CODE_VALUE status
 * throw Exception.get(CommonsStatusCode.INVALID_BASE_CODE_VALUE);
 *
 * // Throwing a BASE_CODE_VALUE_ALREADY_REGISTERED status
 * throw Exception.get(CommonsStatusCode.BASE_CODE_VALUE_ALREADY_REGISTERED);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see RuntimeException
 */
@EqualsAndHashCode(callSuper = false)
@Value
@AllArgsConstructor
class Exception extends RuntimeException {

    StatusCode statusCode;

    Exception(final StatusCode statusCode, final String message) {
        super(message);
        this.statusCode = statusCode;
    }

    Exception(final StatusCode statusCode, final Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    Exception(final StatusCode statusCode, final String message, final Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    /**
     * Creates an {@code Exception} with the specified status code.
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @return An{@code Exception} .
     */
    public static Exception get(final StatusCode statusCode) {
        return new Exception(statusCode);
    }

    /**
     * Creates {@code Exception} with the specified status code and custom message.
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param message    The custom message describing the status.
     * @return An {@code Exception}.
     */
    public static Exception get(final StatusCode statusCode, final String message) {
        return new Exception(statusCode, message);
    }

    /**
     * Creates {@code Exception} with the specified status code and cause.
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param cause      The cause of the status.
     * @return An {@code Exception}.
     */
    public static Exception get(final StatusCode statusCode, final Throwable cause) {
        return new Exception(statusCode, cause);
    }

    /**
     * Creates {@code Exception} with the specified status code, custom message, and cause.
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param message    The custom message describing the status.
     * @param cause      The cause of the status.
     * @return An {@code Exception}.
     */
    public static Exception get(final StatusCode statusCode, final String message, final Throwable cause) {
        return new Exception(statusCode, message, cause);
    }

    /**
     * Retrieves the custom message associated with the {@code Exception}.
     *
     * @return The custom message.
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * Prints the stack trace of the {@code Exception}.
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    /**
     * Customizes the stack trace filling behavior.
     *
     * @return Reference to the {@link Throwable}.
     */
    @Override
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
