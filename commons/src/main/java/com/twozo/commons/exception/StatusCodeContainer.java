package com.twozo.commons.exception;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * The {@code StatusCodeContainer} is a utility class designed to manage the registration
 * and retrieval of baseCode associated with particular {@link Exception}.
 * </p>
 *
 * <p>
 * Ensures that each baseCode is uniquely assigned to an {@link Exception}
 * and prevents duplicate baseCode registrations.
 * </p>
 *
 * <p>
 * Usage example:
 * <pre>
 * {@code
 * StatusCodeContainer.register(1000, "WebDriverException");
 * String enumName = StatusCodeContainer.get(1000);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
public class StatusCodeContainer {

    private static final Map<Integer, String> ERROR_CODE_CONTAINER = new HashMap<>();

    private StatusCodeContainer() {
    }

    /**
     * <p>
     * Registers a baseCode with its associated {@link Exception}.
     * </p>
     *
     * <p>
     * Ensures that the base error code is a multiple of 100 and not already registered.
     * </p>
     *
     * @param baseCode  the unique baseCode to be registered
     * @param exception the name of the {@link Exception} associated with the baseCode
     * @throws StatusCode If the baseCode is not a multiple of 100 or if it's already registered.
     */
    public static void register(final int baseCode, final String exception) {

        if (baseCode % 100 != 0) {
            throw Exception.get(CommonsStatusCode.INVALID_BASE_CODE_VALUE, "Base code must be a multiple of 100");
        }
        final String specificException = get(baseCode);

        if (Objects.isNull(specificException) || specificException.equals(exception)) {
            ERROR_CODE_CONTAINER.put(baseCode, exception);
        } else {
            throw Exception.get(CommonsStatusCode.BASE_CODE_VALUE_ALREADY_REGISTERED, "BaseCode is already assigned");
        }
    }

    /**
     * <p>
     * Retrieves the {@link Exception} name associated with the given baseCode.
     * </p>
     *
     * <p>
     * Returns the name of an {@link Exception} that was registered with the given baseCode.
     * If no name is registered with the given baseCode, returns null.
     * </p>
     *
     * @param baseCode the baseCode whose associated Exception name is to be returned
     * @return the {@link Exception} name associated with the given baseCode, or null if the baseCode is not registered
     */
    public static String get(final int baseCode) {
        return ERROR_CODE_CONTAINER.get(baseCode);
    }
}
