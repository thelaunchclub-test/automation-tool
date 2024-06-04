package com.twozo.commons.exception.provider;

/**
 * <p>
 * Provides functionality to calculate a status code based on a given base code and a specific code.
 * Performs a simple arithmetic operation to derive a status code.
 * </p>
 *
 * <p>
 * The calculation method {@code get} is designed to be simply adding the base code
 * and the specific code to produce the result.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public final class StatusCodeProvider {

    /**
     * <p>
     * Calculates the status code based on the given base code and specific code.
     * </p>
     *
     * @param baseCode     The base code value.
     * @param specificCode The specific code value.
     * @return The calculated status code.
     */
    public int get(final int baseCode, final int specificCode) {
        return baseCode + specificCode;
    }
}
