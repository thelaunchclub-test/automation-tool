package com.twozo.commons.exception;

/**
 * <p>
 * The {@code CommonsException} represents a set of custom exceptions specific to the Commons.
 * </p>
 *
 * <p>
 * Provides a standardized way to handle exceptions that are commonly encountered in Commons,
 * such as invalid input and duplicate input scenarios. Each exception type corresponds to a specific error code
 * which helps in identifying and managing errors more effectively.
 * </p>
 *
 * <p>
 * The error codes for these exceptions are generated dynamically based on a base error code and a specific code
 * unique to each exception type. This ensures that each exception has a distinct and recognizable error code.
 * The base error code is registered only once to prevent redundancy.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * // Throwing an INVALID_BASE_CODE_VALUE exception
 * throw StatusCode.get(CommonsException.INVALID_BASE_CODE_VALUE);
 *
 * // Throwing a BASE_CODE_VALUE_ALREADY_REGISTERED exception
 * throw StatusCode.get(CommonsException.BASE_CODE_VALUE_ALREADY_REGISTERED);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see Exception
 */
public enum CommonsException implements Exception {

    INVALID_BASE_CODE_VALUE(1),
    BASE_CODE_VALUE_ALREADY_REGISTERED(2);

    private final int specificCode;
    private static boolean isBaseErrorCodeRegistered = false;

    static {
        register();
    }

    CommonsException(final int specificCode) {
        this.specificCode = specificCode;
    }

    /**
     * <p>
     * Registers the base error code if it's not already registered.
     * Ensures that the base error code is registered only once.
     * </p>
     */
    private static void register() {
        if (!isBaseErrorCodeRegistered) {
            ErrorCodeContainer.register(ErrorCodeHandler.getBaseErrorCode(), CommonsException.class.getSimpleName());
            isBaseErrorCodeRegistered = true;
        }
    }

    /**
     * <p>
     * Retrieves the error code associated with the exception. Calculates
     * the error code based on the base error code and the specific error code
     * provided by the {@link ErrorCodeHandler}.
     * </p>
     *
     * @return The error code generated based on the base error code and specific error code.
     */
    @Override
    public int getErrorCode() {
        return ErrorCodeGenerator.getErrorCode(specificCode, ErrorCodeHandler.getBaseErrorCode());
    }

    /**
     * <p>
     * The {@code ErrorCodeHandler} is responsible for providing the base error code
     * used in generating specific error codes for {@link CommonsException}.
     * </p>
     *
     * <p>
     * The base error code is a fixed value (100 in this case) which is used as the starting
     * point for generating specific error codes for different exception types defined in the
     * {@link CommonsException}. This approach ensures that each exception type has a
     * unique and identifiable error code.
     * </p>
     */
    static class ErrorCodeHandler implements ErrorCodeGenerator {

        /**
         * <p>
         * Retrieves the base error code value codes.
         * </p>
         *
         * @return The base code value used in generating error codes.
         */
        public static int getBaseErrorCode() {
            return 100;
        }
    }
}