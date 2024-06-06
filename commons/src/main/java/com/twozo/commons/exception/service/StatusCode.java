package com.twozo.commons.exception.service;

/**
 * <p>
 * Provides a standardized way to handle status that are commonly encountered ,such as status codes of
 * commons, web driver and so. Each type corresponds to a specific status code which helps in identifying
 * and managing statuses more effectively.
 * </p>
 *
 * <p>
 * The status codes for these statuses are generated dynamically based on a base code and a specific code
 * unique to each status type. Ensures that each status has a distinct and recognizable code.
 * The base code is registered only once to prevent redundancy.
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
 */
public interface StatusCode {

    /**
     * <p>
     * Retrieves the status code value.
     * </p>
     *
     * @return The status code.
     */
    int getStatusCode();
}
