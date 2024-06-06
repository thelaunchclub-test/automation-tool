package com.twozo.commons.exception;

import com.twozo.commons.exception.service.StatusCode;
import lombok.AllArgsConstructor;

/**
 * <p>
 * Manages statuses with associated status codes and messages.
 * </p>
 *
 * <p>
 * Provides additional context through messages and causes. Ensures a standardized way of
 * handling and reporting issues in the application by associating each status
 * with a specific status code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * throw TestException.get(CommonsStatusCode.INVALID_BASE_CODE_VALUE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see RuntimeException
 */
@AllArgsConstructor
public final class TestException extends RuntimeException {

    private final StatusCode statusCode;

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
     * Creates {@code TestException} with the specified status code and message.
     * </p>
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param message    The message describing the status.
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
     * Creates {@code TestException} with the specified status code, message, and cause.
     * </p>
     *
     * @param statusCode The {@link StatusCode} associated with the status.
     * @param message    The message describing the status.
     * @param cause      The cause of the status.
     * @return An {@code TestException}.
     */
    public static TestException get(final StatusCode statusCode, final String message, final Throwable cause) {
        return new TestException(statusCode, message, cause);
    }

    /**
     * <p>
     * Retrieves the message associated with the {@code TestException}.
     * </p>
     *
     * @return The message.
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
