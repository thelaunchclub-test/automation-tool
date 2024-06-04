package com.twozo.commons.exception.internal.impl;

import com.twozo.commons.exception.status.code.service.StatusCodeGenerator;

/**
 * <p>
 * Generates error codes by combining specific and base error codes.
 * </p>
 *
 * <p>
 * The {@link #calculate(int, int)} ()}  calculates the complete error code by adding the specific code
 * to the base code. Allows for a modular and flexible way of generating error codes
 * that can be easily extended and maintained.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see StatusCodeGenerator
 */
public final class StatusCodeGeneratorImpl implements StatusCodeGenerator {

    /**
     * {@inheritDoc}
     *
     * @param specificCode The specificCode value.
     * @param baseCode     The baseCode value.
     * @return The calculated status code, which is the sum of the specificCode and the baseCode.
     */
    @Override
    public int calculate(final int specificCode, final int baseCode) {
        return specificCode + baseCode;
    }
}
