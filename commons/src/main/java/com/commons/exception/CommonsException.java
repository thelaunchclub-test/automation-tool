package com.commons.exception;

/**
 * The {@code CommonsException} provides functionality to retrieve error codes
 * and error message associated with the exceptions.
 *
 * @author Petchimuthu2015
 * @version 1.0
 */
interface CommonsException {

    /**
     * Gets the error code associated with the exception.
     *
     * @return The error code.
     */
    int getErrorCode();
}
