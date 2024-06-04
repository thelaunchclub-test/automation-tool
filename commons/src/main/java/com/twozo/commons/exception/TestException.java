package com.twozo.commons.exception;

import com.twozo.commons.exception.status.code.service.StatusCode;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * <p>
 * Manages statuses with associated status codes and custom messages.
 * </p>
 *
 * <p>
 * Provides additional context through custom messages and causes. Ensures a standardized way of
 * handling and reporting issues in the application by associating each status
 * with a specific status code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * // Throwing an INVALID_BASE_CODE_VALUE status
 * throw TestException.get(CommonsStatusCode.INVALID_BASE_CODE_VALUE);
 *
 * // Throwing a BASE_CODE_VALUE_ALREADY_REGISTERED status
 * throw TestException.get(CommonsStatusCode.BASE_CODE_VALUE_ALREADY_REGISTERED);
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
public
class TestException extends RuntimeException {

    StatusCode statusCode;

    public TestException(final StatusCode statusCode, final String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public TestException(final StatusCode statusCode, final Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    public TestException(final StatusCode statusCode, final String message, final Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    /**
     * <p>
     * Creates an {@code TestException} with the specified status code.
     * </p>
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @return An{@code TestException} .
     */
    public static TestException get(final StatusCode statusCode) {
        return new TestException(statusCode);
    }

    /**
     * <p>
     * Creates {@code TestException} with the specified status code and custom message.
     * </p>
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param message    The custom message describing the status.
     * @return An {@code TestException}.
     */
    public static TestException get(final StatusCode statusCode, final String message) {
        return new TestException(statusCode, message);
    }

    /**
     * <p>
     * Creates {@code TestException} with the specified status code and cause.
     * </p>
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param cause      The cause of the status.
     * @return An {@code TestException}.
     */
    public static TestException get(final StatusCode statusCode, final Throwable cause) {
        return new TestException(statusCode, cause);
    }

    /**
     * <p>
     * Creates {@code TestException} with the specified status code, custom message, and cause.
     * </p>
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param message    The custom message describing the status.
     * @param cause      The cause of the status.
     * @return An {@code TestException}.
     */
    public static TestException get(final StatusCode statusCode, final String message, final Throwable cause) {
        return new TestException(statusCode, message, cause);
    }

    /**
     * <p>
     * Retrieves the custom message associated with the {@code TestException}.
     * </p>
     *
     * @return The custom message.
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * <p>
     * Prints the stack trace of the {@code TestException}.
     * </p>
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    /**
     * <p>
     * Customizes the stack trace filling behavior.
     * </p>
     *
     * @return Reference to the {@link Throwable}.
     */
    @Override
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
