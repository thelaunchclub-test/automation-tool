package com.twozo.commons.exception;

/**
 * The {@code Exception} provides functionality to retrieve error codes
 * and error message associated with the exceptions.
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface Exception {

    /**
     * Gets the error code associated with the exception.
     *
     * @return The error code.
     */
    int getErrorCode();
}
