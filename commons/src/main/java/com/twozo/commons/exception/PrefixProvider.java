package com.twozo.commons.exception;

/**
 * Defines a contract for providing prefixes for exceptions.
 *
 * <p>
 * The {@code PrefixProvider} allows to provide prefixes used in exception handling.
 * Implementing classes must provide an implementation for the {@link #getPrefix()} method.
 * Additionally, a utility method {@link #getCalculate(int, int)} is provided to calculate prefixes
 * based on a base code and a provider value.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface PrefixProvider {

    /**
     * <p>
     * Returns the prefix value.
     * </p>
     *
     * @return The prefix value as an integer.
     */
    int getPrefix();

    /**
     * <p>
     * Calculates a complete error code by adding the base code and the prefix.
     * </p>
     *
     * <p>
     * Combines the base code and the prefix to generate a unique error code. It is
     * intended to be used as a utility method by classes that implement the {@link PrefixProvider} .
     * </p>
     *
     * @param baseCode The base code value.
     * @param prefix The prefix value.
     * @return The calculated error code, which is the sum of the base code and the prefix.
     */
    static int getCalculate(final int baseCode, final int prefix) {
        return baseCode + prefix;
    }
}
