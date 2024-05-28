package com.twozo.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * <p>
 * The {@code ExceptionHandler} provides functionalities for handling exceptions.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * try {
 *     // Some code that may throw an exception
 *     // For example:
 *     int result = 10 / 0; // This will throw an {@link ArithmeticException}
 * } catch (ArithmeticException ae) {
 *     // Wrap the exception and add a custom message
 *     ExceptionHandler exceptionHandler = new ExceptionHandler(ae, "Division by zero occurred");
 *     // Log or handle the exceptionHandler
 * }
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@AllArgsConstructor
class ExceptionHandler extends RuntimeException {

    Exception exception;

    ExceptionHandler(final Exception exception, final String message) {
        super(message);
        this.exception = exception;
    }

    ExceptionHandler(final Exception exception, final String message, final Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    /**
     * <p>
     * Returns {@link ExceptionHandler} with the specified exception.
     * </p>
     *
     * @param exception {@link Exception}.
     * @return A {@link ExceptionHandler} .
     */
    public static ExceptionHandler get(final Exception exception) {
        return new ExceptionHandler(exception);
    }

    /**
     * <p>
     * Returns {@link ExceptionHandler} with the specified exception and message.
     * </p>
     *
     * @param exception The {@link Exception}.
     * @param message The custom message associated with the exception.
     * @return A {@link ExceptionHandler}.
     */
    public static ExceptionHandler get(final Exception exception, final String message) {
        return new ExceptionHandler(exception, message);
    }

    /**
     * <p>
     * Returns {@link ExceptionHandler} with the specified exception, message, and cause.
     * </p>
     *
     * @param exception The {@link Exception}.
     * @param message The custom message associated with the exception.
     * @param cause The cause of the exception.
     * @return A {@link ExceptionHandler}.
     */
    public static ExceptionHandler get(final Exception exception, final String message, final Throwable cause) {
        return new ExceptionHandler(exception, message, cause);
    }

    /**
     * <p>
     * Retrieves the custom message associated with this {@link ExceptionHandler}.
     * </p>
     *
     * @return The custom message.
     */
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * <p>
     * Prints the stack trace of the original exception.
     * </p>
     */
    public void printStackTrace() {
        super.printStackTrace();
    }

    /**
     * <p>
     * customize stack trace filling behavior.
     * </p>
     *
     * @return Reference to this {@link Throwable}.
     */
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
