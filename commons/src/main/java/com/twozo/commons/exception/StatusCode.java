package com.twozo.commons.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 /**
 * <p>
 * The {@code StatusCode} is used to handle exceptions with associated error codes and custom messages.
 * </p>
 *
 * <p>
 * The {@code StatusCode}'s primary purpose is to encapsulate an {@link Exception} and provide additional
 * context through custom messages and causes. It ensures a standardized way of handling and reporting
 * errors in the application by associating each {@code StatusCode} with a specific exception.
 * </p>
 *
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * try {
 *     // Some code that may throw a WebDriverException
 *     // For example:
 *     WebDriver driver = new ChromeDriver();
 *     WebElement element = driver.findElement(By.id("nonexistent-element"));
 *     element.click(); // This may throw an ELEMENT_NOT_VISIBLE_EXCEPTION
 *
 * } catch (NoSuchElementException exception) {
 *     throw new ExceptionHandler(WebDriverException.ELEMENT_NOT_VISIBLE_EXCEPTION, "Element not visible during click operation");
 * }
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see RuntimeException
 */
@EqualsAndHashCode(callSuper = false)
@Value
@AllArgsConstructor
class StatusCode extends RuntimeException {

    Exception exception;

    StatusCode(final Exception exception, final String message) {
        super(message);
        this.exception = exception;
    }

    StatusCode(final Exception exception, final Throwable cause) {
        super(cause);
        this.exception = exception;
    }

    StatusCode(final Exception exception, final String message, final Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    /**
     * Returns a {@code StatusCode} with the specified exception.
     *
     * @param exception The {@link Exception} .
     * @return A {@code StatusCode} .
     */
    public static StatusCode get(final Exception exception) {
        return new StatusCode(exception);
    }

    /**
     * Returns a {@code StatusCode} with the specified {@link Exception} and message.
     *
     * @param exception The {@link Exception} .
     * @param message   The custom message to be associated with the {@link Exception}.
     * @return A {@code StatusCode} .
     */
    public static StatusCode get(final Exception exception, final String message) {
        return new StatusCode(exception, message);
    }

    /**
     * Returns a {@code StatusCode} with the specified {@link Exception} and cause.
     *
     * @param exception The {@link Exception} .
     * @param cause     The cause of the {@link Exception}.
     * @return A {@code StatusCode} .
     */
    public static StatusCode get(final Exception exception, final Throwable cause) {
        return new StatusCode(exception, cause);
    }

    /**
     * Returns a {@code StatusCode} with the specified {@link Exception}, message, and cause.
     *
     * @param exception The {@link Exception}.
     * @param message   The custom message to be associated with the {@link Exception}.
     * @param cause     The cause of the {@link Exception}.
     * @return A {@code StatusCode} .
     */
    public static StatusCode get(final Exception exception, final String message, final Throwable cause) {
        return new StatusCode(exception, message, cause);
    }

    /**
     * Retrieves the custom message associated with this {@code StatusCode}.
     *
     * @return The custom message.
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * Prints the stack trace of the original {@link Exception}.
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    /**
     * Customizes stack trace filling behavior.
     *
     * @return Reference to this {@link Throwable}.
     */
    @Override
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
