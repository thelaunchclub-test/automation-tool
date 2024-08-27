package com.twozo.commons.json.status;

import com.twozo.commons.exception.provider.PrefixProvider;
import com.twozo.commons.exception.service.ErrorCodeProvider;

/**
 * <p>
 * Standardizes handling of Json errors like invalid and duplicate inputs with specific error codes
 * for effective identification.
 * </p>
 *
 * <p>
 * Dynamically generates unique codes using a base and specific error code for each type.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * throw ErrorCode.get(JsonErrorCode.INVALID_BASE_CODE_VALUE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ErrorCodeProvider
 */
public enum JsonErrorCode implements ErrorCodeProvider {

    INVALID_DECODER(1),
    INVALID_DATA(2);

    private static final PrefixProvider PREFIX_PROVIDER = new PrefixProvider();
    private static final int BASE_CODE = 0x1000;

    private final int code;

    JsonErrorCode(final int code) {
        this.code = code;
    }

    /**
     * {@inheritDoc}
     *
     * @return The error code.
     */
    @Override
    public int getErrorCode() {
        return PREFIX_PROVIDER.get(BASE_CODE, code);
    }
}
