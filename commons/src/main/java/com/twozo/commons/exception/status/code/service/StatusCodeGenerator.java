package com.twozo.commons.exception.status.code.service;

/**
 * <p>
 * Generates error codes by combining specific and base error codes.
 * </p>
 *
 * <p>
 * The {@link #calculate(int, int)} calculates the complete error code by adding the specific code
 * to the base code. Allows for a modular and flexible way of generating error codes
 * that can be easily extended and maintained.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * StatusCodeGenerator generator = new StatusCodeGeneratorImpl();
 * int baseCode = 1000;
 * int specificCode = 200;
 * int statusCode = generator.calculate(specificCode, baseCode); // Returns 1200
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface StatusCodeGenerator {

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
