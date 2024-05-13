package com.commons.exception;

/**
 * The {@code ExceptionHandler} class provides functionalities for handling exceptions.
 * It extends RuntimeException to allow unchecked commonsException propagation.
 *
 * <p>
 * This class can be used to wrap original exceptions with additional custom messages or causes.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * try {
 *     // Some code that may throw an commonsException
 *     // For example:
 *     int result = 10 / 0; // This will throw an ArithmeticException
 * } catch (ArithmeticException ae) {
 *     // Wrap the commonsException and add a custom message
 *     ExceptionHandler exceptionHandler = new ExceptionHandler(ae, "Division by zero occurred");
 *     // Log or handle the exceptionHandler
 * }
 * }</pre>
 * </p>
 *
 * @author Petchimuthu2015
 * @version 1.0
 */
final class ExceptionHandler extends RuntimeException {

    private final CommonsException commonsException;

    public ExceptionHandler(final CommonsException commonsException) {
        this.commonsException = commonsException;
    }

    ExceptionHandler(final CommonsException commonsException, final String message) {
        super(message);
        this.commonsException = commonsException;
    }

    ExceptionHandler(final CommonsException commonsException, final String message, final Throwable cause) {
        super(message, cause);
        this.commonsException = commonsException;
    }

    /**
     * Returns {@link ExceptionHandler} with the specified commonsException.
     *
     * @param commonsException The original commonsException.
     * @return A new ExceptionHandler instance.
     */
    public static ExceptionHandler get(final CommonsException commonsException) {
        return new ExceptionHandler(commonsException);
    }

    /**
     * Returns {@link ExceptionHandler} with the specified commonsException and message.
     *
     * @param commonsException The original commonsException.
     * @param message   The custom message associated with the commonsException.
     * @return A new ExceptionHandler instance.
     */
    public static ExceptionHandler get(final CommonsException commonsException, final String message) {
        return new ExceptionHandler(commonsException, message);
    }

    /**
     * Returns {@link ExceptionHandler} with the specified commonsException, message, and cause.
     *
     * @param commonsException The original commonsException.
     * @param message   The custom message associated with the commonsException.
     * @param cause     The cause of the commonsException.
     * @return A new ExceptionHandler instance.
     */
    public static ExceptionHandler get(final CommonsException commonsException, final String message, final Throwable cause) {
        return new ExceptionHandler(commonsException, message, cause);
    }

    /**
     * Retrieves the custom message associated with this ExceptionHandler.
     *
     * @return The custom message.
     */
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * Prints the stack trace of the original commonsException.
     */
    public void printStackTrace() {
        super.printStackTrace();
    }

    /**
     * customize stack trace filling behavior.
     *
     * @return Reference to this Throwable object, usually ignored as the object is mutated in place.
     */
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
