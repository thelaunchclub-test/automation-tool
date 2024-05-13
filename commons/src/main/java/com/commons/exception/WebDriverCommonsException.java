package com.commons.exception;

/**
 * Represents Selenium exceptions.
 * <p>
 * This enumeration provides a set of exceptions commonly encountered in Selenium WebDriver operations.
 * Each enum constant corresponds to a specific exception type along with its associated error code.
 * </p>
 *
 * @author Petchimuthu2015
 * @version 1.0
 */
public enum WebDriverCommonsException implements CommonsException {


    ELEMENT_CLICK_INTERCEPTED_EXCEPTION(1),
    ELEMENT_NOT_SELECTABLE_EXCEPTION(2),
    ELEMENT_NOT_VISIBLE_EXCEPTION(3);

    private final int baseErrorCode;
    private final ErrorCodeHandler errorCodeHandler;

    /**
     * Constructs a WebDriverCommonsException with the specified base error code.
     *
     * @param baseErrorCode The base error code for the exception.
     */
    WebDriverCommonsException(final int baseErrorCode) {
        this.baseErrorCode = baseErrorCode;
        this.errorCodeHandler = new ErrorCodeHandler();
    }

    /**
     * Retrieves the error code associated with the exception.
     * <p>
     * This method calculates the error code based on the base error code and the prefix
     * provided by the ErrorCodeHandler.
     * </p>
     *
     * @return The error code generated based on the base error code and prefix.
     */
    @Override
    public int getErrorCode() {
        return PrefixProvider.getCalculate(baseErrorCode, errorCodeHandler.getPrefix());
    }

    /**
     * Inner class to handle error codes.
     * <p>
     * Provides prefix values for error codes associated with WebDriver exceptions.
     * </p>
     */
    static class ErrorCodeHandler implements PrefixProvider {

        /**
         * Retrieves the prefix value for error codes.
         *
         * @return The prefix value used in generating error codes.
         */
        @Override
        public int getPrefix() {
            return 1000;
        }
    }
}
