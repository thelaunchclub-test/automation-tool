package com.twozo.commons.exception;

/**
 * <p>
 * The {@code ErrorCodeGenerator} generates error codes by combining specific and base error codes.
 * </p>
 *
 * <p>
 * The {@code getErrorCode} calculates the complete error code by adding the specific code
 * to the base code. This allows for a modular and flexible way of generating error codes
 * that can be easily extended and maintained.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface ErrorCodeGenerator {

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
     * @param baseCode     The baseCode value.
     * @return The calculated error code, which is the sum of the specificCode and the baseCode.
     */
    static int getErrorCode(final int specificCode, final int baseCode) {
        return specificCode + baseCode;
    }
}
