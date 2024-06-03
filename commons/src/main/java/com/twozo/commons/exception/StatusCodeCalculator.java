package com.twozo.commons.exception;

/**
 * <p>
 * The {@code StatusCodeCalculator} generates error codes by combining specific and base error codes.
 * </p>
 *
 * <p>
 * The {@code getStatusCode} calculates the complete error code by adding the specific code
 * to the base code. Allows for a modular and flexible way of generating error codes
 * that can be easily extended and maintained.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface StatusCodeCalculator {

    /**
     * <p>
     * Calculates a complete status code by adding the specific code and the base code.
     * </p>
     *
     * <p>
     * Combines the specificCode and the baseCode to generate a unique status code.
     * </p>
     *
     * @param specificCode The specificCode value.
     * @param baseCode     The baseCode value.
     * @return The calculated status code, which is the sum of the specificCode and the baseCode.
     */
    int calculate(final int specificCode, final int baseCode);
}
