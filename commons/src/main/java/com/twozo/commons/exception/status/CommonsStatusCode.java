package com.twozo.commons.exception.status;

import com.twozo.commons.exception.provider.StatusCodeProvider;
import com.twozo.commons.exception.registry.StatusCodeRegistry;
import com.twozo.commons.exception.service.StatusCode;

/**
 * <p>
 * Standardizes handling of common statuses like invalid and duplicate inputs with specific codes
 * for effective identification.
 * </p>
 *
 * <p>
 * Dynamically generates unique codes using a base and specific code for each type, with the base code
 * registered once to avoid redundancy.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * // Throwing an INVALID_BASE_CODE_VALUE status
 * throw TestException.get(CommonsStatusCode.INVALID_BASE_CODE_VALUE);
 *
 * // Throwing a BASE_CODE_VALUE_ALREADY_REGISTERED status
 * throw TestException.get(CommonsStatusCode.BASE_CODE_VALUE_ALREADY_REGISTERED);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see StatusCode
 */
public enum CommonsStatusCode implements StatusCode {

    INVALID_BASE_CODE(1),
    BASE_CODE_ALREADY_REGISTERED(2);

    private static final StatusCodeProvider STATUS_CODE_PROVIDER = new StatusCodeProvider();
    private static final int BASE_CODE = 100;
    private static boolean isBaseCodeRegistered = false;

    private final int code;

    CommonsStatusCode(final int code) {
        this.code = code;
    }

    static {
        register();
    }

    /**
     * <p>
     * Registers the base code if it's not already registered. Ensures that the base code is registered only once.
     * </p>
     */
    private static void register() {

        if (!isBaseCodeRegistered) {
            StatusCodeRegistry.register(BASE_CODE, CommonsStatusCode.class.getSimpleName());
            isBaseCodeRegistered = true;
        }
    }

    /**
     * <p>
     * Retrieves the status code associated with the status.
     * </p>
     *
     * @return The status code generated based on the base code and specific code.
     */
    @Override
    public int getStatusCode() {
        return STATUS_CODE_PROVIDER.get(BASE_CODE, code);
    }
}
