package com.twozo.commons.exception;

/**
 * Defines a contract for providing prefixes for exceptions.
 *
 * <p>
 * The PrefixProvider allows classes to provide prefixes used in exception handling.
 * Implementing classes must provide an implementation for the {@link #getPrefix()} method.
 * Additionally, a utility method {@link #getCalculate(int, int)} is provided to calculate prefixes
 * based on a base code and a provider value.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface PrefixProvider {

    /**
     * Returns the prefix value.
     *
     * @return The prefix value.
     */
    int getPrefix();

    /**
     * Calculates the prefix based on a base code and a provider value.
     *
     * @param baseCode The base code value.
     * @param provider The provider value.
     * @return The calculated prefix value.
     */
    static int getCalculate(final int baseCode, final int provider) {
        return baseCode + provider;
    }
}
