package com.twozo.web.status.code;

import com.twozo.commons.exception.StatusCodeProvider;
import com.twozo.commons.exception.StatusCode;
import com.twozo.commons.exception.StatusCodeCalculatorImpl;
import com.twozo.commons.exception.StatusCodeContainer;

/**
 * <p>
 * The {@code WebDriverStatusCode} represents a set of custom exceptions specific to the WebDriver.
 * </p>
 *
 * <p>
 * Provides a standardized way to handle exceptions that are commonly encountered in WebDriver,
 * such as element click intercepted and element not visible. Each exception type corresponds to a specific status code
 * which helps in identifying and managing statuses more effectively.
 * </p>
 *
 * <p>
 * The status codes for these exceptions are generated dynamically based on a base status code and a specific code
 * unique to each exception type. Ensures that each exception has a distinct and recognizable status
 * code.
 * The base status code is registered only once to prevent redundancy.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * // Throwing an ELEMENT_CLICK_INTERCEPTED exception
 * throw StatusCode.get(WebDriverStatusCode.ELEMENT_CLICK_INTERCEPTED);
 *
 * // Throwing a ELEMENT_NOT_VISIBLE exception
 * throw StatusCode.get(WebDriverStatusCode.ELEMENT_NOT_VISIBLE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see StatusCode
 */
public enum WebDriverStatusCode implements StatusCode {

    ELEMENT_CLICK_INTERCEPTED(1),
    ELEMENT_NOT_SELECTABLE(2),
    ELEMENT_NOT_VISIBLE(3);

    private static final StatusCodeProvider STATUS_CODE_PROVIDER = new StatusCodeProvider(new StatusCodeCalculatorImpl());
    private static final int BASE_STATUS_CODE = 200;
    private static boolean isBaseCodeRegistered = false;

    private final int specificCode;

    static {
        register();
    }

    /**
     * <p>
     * Registers the base status code if it's not already registered.
     * Ensures that the base status code is registered only once.
     * </p>
     */
    private static void register() {
        if (!isBaseCodeRegistered) {
            StatusCodeContainer.register(BASE_STATUS_CODE, WebDriverStatusCode.class.getSimpleName());
            isBaseCodeRegistered = true;
        }
    }

    WebDriverStatusCode(final int specificCode) {
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
        return STATUS_CODE_PROVIDER.get(BASE_STATUS_CODE, specificCode);
    }
}
