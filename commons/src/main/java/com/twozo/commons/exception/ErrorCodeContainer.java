package com.twozo.commons.exception;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * The {@code ErrorCodeContainer} is a utility class designed to manage the registration
 * and retrieval of prefixes associated with {@link Enum}.
 * </p>
 *
 * <p>
 * Ensures that each prefix is uniquely assigned to an {@link Enum}
 * and prevents duplicate prefix registrations.
 * </p>
 *
 * <p>
 * Usage example:
 * <pre>
 * {@code
 * ErrorCodeContainer.register(1000, "WebDriverException");
 * String enumName = ErrorCodeContainer.get(1000);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
public class ErrorCodeContainer {

    private static final Map<Integer, String> CONTAINER = new HashMap<>();

    private ErrorCodeContainer() {
    }

    /**
     * <p>
     * Registers a baseCode with its associated {@link Enum}.
     * </p>
     *
     * <p>
     * Checks the base code, if it is invalid or already registered an {@link IllegalArgumentException} is thrown.
     * Otherwise, the baseCode and enum name are added to the container.
     * </p>
     *
     * @param baseCode the unique baseCode to be registered
     * @param enumName the name of the {@link Enum} associated with the baseCode
     * @throws IllegalArgumentException if the baseCode is already registered
     */
    public static void register(final int baseCode, final String enumName) {
        if (baseCode % 100 != 0) {
            throw new IllegalArgumentException("Base code must be a multiple of 100.");
        }
        final String specificEnumName = get(baseCode);

        if (specificEnumName == null || specificEnumName.equals(enumName)) {
            CONTAINER.put(baseCode, enumName);
        } else {
            throw new IllegalArgumentException("Prefix is already assigned");
        }
    }

    /**
     * <p>
     * Retrieves the {@link Enum} name associated with the given baseCode.
     * </p>
     *
     * <p>
     * Returns the name of an {@link Enum} that was registered with the given baseCode.
     * If no name is registered with the given baseCode, this method returns null.
     * </p>
     *
     * @param key the baseCode whose associated enumeration name is to be returned
     * @return the {@link Enum} name associated with the given baseCode, or null if the baseCode is not registered
     */
    public static String get(final int key) {
        return CONTAINER.get(key);
    }
}
