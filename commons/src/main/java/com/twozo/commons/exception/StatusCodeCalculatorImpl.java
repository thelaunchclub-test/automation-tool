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
 * @see StatusCodeCalculator
 */
public class StatusCodeCalculatorImpl implements StatusCodeCalculator {
    /**
     * {@inheritDoc}
     *
     * @param specificCode The specificCode value.
     * @param baseCode     The baseCode value.
     * @return The calculated status code, which is the sum of the specificCode and the baseCode.
     */
    @Override
    public int calculate(int specificCode, int baseCode) {
        return specificCode + baseCode;
    }
}
