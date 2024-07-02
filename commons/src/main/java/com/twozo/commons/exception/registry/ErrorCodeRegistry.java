package com.twozo.commons.exception.registry;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.commons.exception.status.CommonsErrorCode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * Manages the registration and retrieval of baseCode associated with particular {@link ErrorCode}.
 * </p>
 *
 * <p>
 * Ensures that each baseCode is uniquely assigned to an {@link ErrorCode}
 * and prevents duplicate baseCode registrations.
 * </p>
 *
 * <p>
 * Usage example:
 * <pre>
 * {@code
 * ErrorCodeRegistry.register(1000, "WebDriverException");
 * String exception = ErrorCodeRegistry.get(1000);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class ErrorCodeRegistry {

    private static final Map<Integer, String> ERROR_CODE_REGISTRY = new HashMap<>();

    /**
     * <p>
     * Registers a baseCode with its associated {@link ErrorCode}.
     * </p>
     *
     * <p>
     * Ensures that the base error code is a multiple of 100 and not already registered.
     * </p>
     *
     * @param baseCode  the unique baseCode to be registered
     * @param exception the name of the {@link ErrorCode} associated with the baseCode
     */
    public static void register(final int baseCode, final String exception) {

        if (baseCode % 100 != 0) {
            throw ErrorCode.get(CommonsErrorCode.INVALID_BASE_CODE, "Base code must be a multiple of 100");
        }
        final String specificException = get(baseCode);

        if (Objects.isNull(specificException) || specificException.equals(exception)) {
            ERROR_CODE_REGISTRY.put(baseCode, exception);
        } else {
            throw ErrorCode.get(CommonsErrorCode.BASE_CODE_ALREADY_REGISTERED, "BaseCode is already assigned");
        }
    }

    /**
     * <p>
     * Retrieves the {@link ErrorCode} name associated with the given baseCode.
     * </p>
     *
     * <p>
     * Returns the name of an {@link ErrorCode} that was registered with the given baseCode.
     * If no name is registered with the given baseCode, returns null.
     * </p>
     *
     * @param baseCode the baseCode whose associated ErrorCode name is to be returned
     * @return the {@link ErrorCode} name associated with the given baseCode, or null if the baseCode is not registered
     */
    public static String get(final int baseCode) {
        return ERROR_CODE_REGISTRY.get(baseCode);
    }
}
