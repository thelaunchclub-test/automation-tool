package com.twozo.commons.exception.provider;

/**
 *  <p>
 * Provides functionality to calculate a error code based on a given error code and a specific error code.
 * Performs a simple arithmetic operation to derive a error code.
 * </p>
 *
 * <p>
 * The calculation method {@code get} is designed to be simply adding the error code
 * and the specific error code to produce the result.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public final class PrefixProvider {

    /**
     * <p>
     * Calculates the status code based on the given error code and specific error code.
     * </p>
     *
     * @param baseCode     The base code value.
     * @param specificErrorCode The specific code value.
     * @return The calculated status code.
     */
    public int get(final int baseCode, final int specificErrorCode) {
        return baseCode + specificErrorCode;
    }
}
