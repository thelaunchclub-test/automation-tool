package com.twozo.commons.exception.status;

import com.twozo.commons.exception.provider.PrefixProvider;
import com.twozo.commons.exception.service.ErrorCodeProvider;

/**
 * <p>
 * Standardizes handling of common errors like invalid and duplicate inputs with specific error codes
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
 * throw ErrorCode.get(CommonsErrorCode.INVALID_BASE_CODE_VALUE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ErrorCodeProvider
 */
public enum CommonsErrorCode implements ErrorCodeProvider {

    INVALID_BASE_CODE(1),
    BASE_CODE_ALREADY_REGISTERED(2);

    private static final PrefixProvider PREFIX_PROVIDER = new PrefixProvider();
    private static final int BASE_CODE = 0x1000;
    private static boolean isBaseCodeRegistered = false;

    private final int code;

    CommonsErrorCode(final int code) {
        this.code = code;
    }

//    static {
//        register();
//    }
//
//    /**
//     * <p>
//     * Registers the base code if it's not already registered. Ensures that the base code is registered only once.
//     * </p>
//     */
//    private static void register() {
//
//        if (!isBaseCodeRegistered) {
//            ErrorCodeRegistry.register(BASE_CODE, CommonsErrorCode.class.getSimpleName());
//            isBaseCodeRegistered = true;
//        }
//    }

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
