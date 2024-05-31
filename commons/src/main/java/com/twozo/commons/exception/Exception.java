package com.twozo.commons.exception;

/**
 * <p>
 * The {@code Exception} defines a contract for exceptions that are associated with error codes.
 * Retrieves the specific error code related to the exception.
 * </p>
 *
 * <p>
 * Intends to standardize the way error codes are managed and retrieved across different
 * types of exceptions in an application. Exceptions can be consistently
 * handled and their error codes can be easily accessed.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface Exception {

    /**
     * <p>
     * Returns the error code associated with the {@code Exception}.
     * </p>
     *
     * @return The error code.
     */
    int getErrorCode();
}
