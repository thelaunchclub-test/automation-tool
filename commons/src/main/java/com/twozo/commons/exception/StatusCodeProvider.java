package com.twozo.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * <p>
 * The {@code StatusCodeProvider} provides a mechanism to calculate status codes based on
 * a given base code and specific code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * // Create an instance of StatusCodeProvider with a StatusCodeCalculator
 * StatusCodeProvider provider = new StatusCodeProvider(new StatusCodeCalculator);
 *
 * // Get the status code using the provider
 * int statusCode = provider.get(baseCode, specificCode);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see StatusCodeCalculator
 */
@Value
@AllArgsConstructor
public class StatusCodeProvider {

    StatusCodeCalculator statusCodeCalculator;

    /**
     * Calculates the status code based on the given base code and specific code.
     *
     * @param baseCode     The base code value.
     * @param specificCode The specific code value.
     * @return The calculated status code.
     */
    public int get(final int baseCode, final int specificCode) {
        return statusCodeCalculator.calculate(baseCode, specificCode);
    }
}
