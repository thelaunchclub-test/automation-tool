package com.twozo.commons.exception.status;

import com.twozo.commons.exception.TestException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * Manages the registration and retrieval of baseCode associated with particular {@link TestException}.
 * </p>
 *
 * <p>
 * Ensures that each baseCode is uniquely assigned to an {@link TestException}
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class StatusCodeContainer {

    private static final Map<Integer, String> STATUS_CODE_CONTAINER = new HashMap<>();

    /**
     * <p>
     * Registers a baseCode with its associated {@link TestException}.
     * </p>
     *
     * <p>
     * Ensures that the base error code is a multiple of 100 and not already registered.
     * </p>
     *
     * @param baseCode  the unique baseCode to be registered
     * @param exception the name of the {@link TestException} associated with the baseCode
     */
    public static void register(final int baseCode, final String exception) {

        if (baseCode % 100 != 0) {
            throw TestException.get(CommonsStatusCode.INVALID_BASE_CODE, "Base code must be a multiple of 100");
        }
        final String specificException = get(baseCode);

        if (Objects.isNull(specificException) || specificException.equals(exception)) {
            STATUS_CODE_CONTAINER.put(baseCode, exception);
        } else {
            throw TestException.get(CommonsStatusCode.BASE_CODE_ALREADY_REGISTERED, "BaseCode is already assigned");
        }
    }

    /**
     * <p>
     * Retrieves the {@link TestException} name associated with the given baseCode.
     * </p>
     *
     * <p>
     * Returns the name of an {@link TestException} that was registered with the given baseCode.
     * If no name is registered with the given baseCode, returns null.
     * </p>
     *
     * @param baseCode the baseCode whose associated TestException name is to be returned
     * @return the {@link TestException} name associated with the given baseCode, or null if the baseCode is not registered
     */
    public static String get(final int baseCode) {
        return STATUS_CODE_CONTAINER.get(baseCode);
    }
}
