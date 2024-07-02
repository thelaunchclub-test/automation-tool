package com.twozo.commons.exception.service;

/**
 * <p>
 * Provides a standardized way to handle errors that are commonly encountered ,such as error codes of
 * commons, web driver and so. Each type corresponds to a specific error code which helps in identifying
 * and managing errors more effectively.
 * </p>
 *
 * <p>
 * The error codes for these errors are generated dynamically based on a base error code and a specific error code
 * unique to each error type. Ensures that each error has a distinct and recognizable code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * throw ErrorCode.get(CommonsErrorCode.INVALID_BASE_CODE_VALUE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ErrorCodeProvider {

    /**
     * <p>
     * Retrieves the error code value.
     * </p>
     *
     * @return The error code.
     */
    int getErrorCode();
}
