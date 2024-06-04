package com.twozo.commons.exception.status.code;

import com.twozo.commons.exception.status.code.service.StatusCodeGenerator;
import lombok.AllArgsConstructor;

/**
 * <p>
 * Provides a mechanism to calculate status codes based on a given base code and specific code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * // Create an instance of StatusCodeProvider with a StatusCodeGenerator
 * StatusCodeProvider provider = new StatusCodeProvider(new StatusCodeGenerator);
 *
 * // Get the status code using the provider
 * int statusCode = provider.get(baseCode, specificCode);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see StatusCodeGenerator
 */
@AllArgsConstructor
public final class StatusCodeProvider {

    private final StatusCodeGenerator statusCodeGenerator;

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
        return statusCodeGenerator.calculate(baseCode, specificCode);
    }
}
