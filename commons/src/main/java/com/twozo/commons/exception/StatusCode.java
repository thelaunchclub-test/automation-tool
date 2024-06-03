package com.twozo.commons.exception;

/**
 * The {@code StatusCode} represents a status code.
 *
 * <p>
 * Defines {@code getStatusCode()} which retrieves the status code value.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * // Create an instance of a class implementing StatusCode interface
 * StatusCode statusCode = new StatusCodeImpl();
 *
 * // Get the status code value
 * int code = statusCode.getStatusCode();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface StatusCode {

    /**
     * Retrieves the status code value.
     *
     * @return The status code.
     */
    int getStatusCode();
}
