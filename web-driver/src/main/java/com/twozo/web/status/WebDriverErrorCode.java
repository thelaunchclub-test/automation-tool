package com.twozo.web.status;

import com.twozo.commons.exception.provider.PrefixProvider;
import com.twozo.commons.exception.service.ErrorCodeProvider;

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
 * throw TestException.get(WebDriverStatusCode.ELEMENT_CLICK_INTERCEPTED);
 * throw TestException.get(WebDriverStatusCode.ELEMENT_NOT_VISIBLE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ErrorCodeProvider
 */
public enum WebDriverErrorCode implements ErrorCodeProvider {

    ELEMENT_CLICK_INTERCEPTED(1),
    ELEMENT_NOT_SELECTABLE(2),
    ELEMENT_NOT_VISIBLE(3),
    EXPECTED_PAGE_NOT_FOUND(4);

    private static final PrefixProvider PREFIX_PROVIDER = new PrefixProvider();
    private static final int BASE_CODE = 0x2000;

    private final int code;

    WebDriverErrorCode(final int code) {
        this.code = code;
    }

    /**
     * <p>
     * Retrieves the error code value.
     * </p>
     *
     * @return The error code.
     */
    @Override
    public int getErrorCode() {
        return PREFIX_PROVIDER.get(BASE_CODE, code);
    }
}
