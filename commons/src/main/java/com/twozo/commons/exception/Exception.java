package com.twozo.commons.exception;

/**
 * <p>
 * The {@code Exception} provides functionality to retrieve error codes
 * and error message associated with the {@link Exception}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface Exception {

    /**
     * <p>
     * Gets the error code associated with the {@code Exception}.
     * </p>
     *
     * @return The error code.
     */
    int getErrorCode();
}
