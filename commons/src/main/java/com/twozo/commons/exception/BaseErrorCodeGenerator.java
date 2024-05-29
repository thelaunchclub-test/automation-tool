package com.twozo.commons.exception;

/**
 * <p>
 * Defines a contract for providing error code for exceptions.
 * </p>
 *
 * <p>
 * The {@code BaseErrorCodeGenerator} allows to provide base error code used in exception handling.
 * Additionally, a utility method {@link #getErrorCode(int, int)} is provided to calculate error
 * code based on a base code and a specific code.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface BaseErrorCodeGenerator {

    /**
     * <p>
     * Returns the base error code.
     * </p>
     *
     * @return The base error code as an integer.
     */
    int getBaseErrorCode();

    /**
     * <p>
     * Calculates a complete error code by adding the specific code and the base code.
     * </p>
     *
     * <p>
     * Combines the specificCode and the baseCode to generate a unique error code.
     * </p>
     *
     * @param specificCode The specificCode value.
     * @param baseCode The baseCode value.
     * @return The calculated error code, which is the sum of the specificCode and the baseCode.
     */
    static int getErrorCode(final int specificCode, final int baseCode) {
        return specificCode + baseCode;
    }
}
