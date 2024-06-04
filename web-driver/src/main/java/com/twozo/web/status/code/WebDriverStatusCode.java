package com.twozo.web.status.code;

import com.twozo.commons.exception.status.code.StatusCodeProvider;
import com.twozo.commons.exception.status.code.service.StatusCode;
import com.twozo.commons.exception.internal.impl.StatusCodeGeneratorImpl;
import com.twozo.commons.exception.status.code.StatusCodeContainer;

/**
 * <p>
 * Standardizes handling of common statuses like invalid and duplicate inputs with specific codes
 * for effective identification.
 * </p>
 *
 * <p>
 * Dynamically generates unique codes using a base and specific code
 * for each type, with the base code registered once to avoid redundancy.
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

    private static final StatusCodeProvider STATUS_CODE_PROVIDER = new StatusCodeProvider(new StatusCodeGeneratorImpl());
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
