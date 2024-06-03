package com.twozo.web.exception;

import com.twozo.commons.exception.CommonsException;
import com.twozo.commons.exception.ErrorCodeContainer;
import com.twozo.commons.exception.ErrorCodeGenerator;
import com.twozo.commons.exception.Exception;

/**
 * <p>
 * The {@code WebDriverException} represents a set of custom exceptions specific to the WebDriver.
 * </p>
 *
 * <p>
 * Provides a standardized way to handle exceptions that are commonly encountered in WebDriver,
 * such as element click intercepted and element not visible. Each exception type corresponds to a specific error code
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
 * // Throwing an ELEMENT_CLICK_INTERCEPTED exception
 * throw StatusCode.get(WebDriverException.ELEMENT_CLICK_INTERCEPTED);
 *
 * // Throwing a ELEMENT_NOT_VISIBLE exception
 * throw StatusCode.get(WebDriverException.ELEMENT_NOT_VISIBLE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see Exception
 */
public enum WebDriverException implements Exception {

    ELEMENT_CLICK_INTERCEPTED(1),
    ELEMENT_NOT_SELECTABLE(2),
    ELEMENT_NOT_VISIBLE(3);

    private final int specificCode;

    private static boolean isBaseErrorCodeRegistered = false;

    static {
        register();
    }

    /**
     * <p>
     * Registers the base error code if it's not already registered.
     * Ensures that the base error code is registered only once.
     * </p>
     */
    private static void register() {
        if (!isBaseErrorCodeRegistered) {
            ErrorCodeContainer.register(ErrorCodeHandler.getBaseErrorCode(), WebDriverException.class.getSimpleName());
            isBaseErrorCodeRegistered = true;
        }
    }

    WebDriverException(final int specificCode) {
        this.specificCode = specificCode;
    }

    /**
     * <p>
     * Retrieves the error code associated with the exception. Calculates
     * the error code based on the base error code and the specific error code
     * provided by the {@code ErrorCodeHandler}.
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
         * Retrieves the prefix value for error codes.
         * </p>
         *
         * @return The prefix value used in generating error codes.
         */
        public static int getBaseErrorCode() {
            return 100;
        }
    }
}
