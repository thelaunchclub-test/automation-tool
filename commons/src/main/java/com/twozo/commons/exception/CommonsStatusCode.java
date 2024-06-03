package com.twozo.commons.exception;

/**
 * <p>
 * The {@code CommonsStatusCode} represents a set of custom statuses specific to the Commons.
 * </p>
 *
 * <p>
 * Provides a standardized way to handle status that are commonly encountered in Commons,
 * such as invalid input and duplicate input scenarios. Each type corresponds to a specific status code
 * which helps in identifying and managing statuses more effectively.
 * </p>
 *
 * <p>
 * The status codes for these statuses are generated dynamically based on a base code and a specific code
 * unique to each status type. Ensures that each status has a distinct and recognizable code.
 * The base code is registered only once to prevent redundancy.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * // Throwing an INVALID_BASE_CODE_VALUE status
 * throw Exception.get(CommonsStatusCode.INVALID_BASE_CODE_VALUE);
 *
 * // Throwing a BASE_CODE_VALUE_ALREADY_REGISTERED status
 * throw Exception.get(CommonsStatusCode.BASE_CODE_VALUE_ALREADY_REGISTERED);
 * }
 * </pre>
 * </p>
 *
 * @version 1.0
 * @see StatusCode
 */
public enum CommonsStatusCode implements StatusCode {

    INVALID_BASE_CODE_VALUE(1),
    BASE_CODE_VALUE_ALREADY_REGISTERED(2);

    private static final StatusCodeProvider statusCodeProvider = new StatusCodeProvider(new StatusCodeCalculatorImpl());
    private static final int BASE_STATUS_CODE = 100;
    private static boolean isBaseCodeRegistered = false;

    private final int specificCode;


    static {
        register();
    }

    /**
     * <p>
     * Registers the base code if it's not already registered.
     * Ensures that the base code is registered only once.
     * </p>
     */
    private static void register() {
        if (!isBaseCodeRegistered) {
            StatusCodeContainer.register(BASE_STATUS_CODE, CommonsStatusCode.class.getSimpleName());
            isBaseCodeRegistered = true;
        }
    }

    CommonsStatusCode(final int specificCode) {
        this.specificCode = specificCode;
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
        return statusCodeProvider.get(BASE_STATUS_CODE, specificCode);
    }
}
