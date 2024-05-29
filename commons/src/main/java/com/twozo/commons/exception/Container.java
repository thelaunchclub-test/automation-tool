package com.twozo.commons.exception;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * The {@code Container} is a utility class designed to manage the registration
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
 * Container.register(1000, "WebDriverException");
 * String enumName = Container.get(1000);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
public class Container {

    private static final Map<Integer, String> prefixMap = new HashMap<>();

    private Container() {
    }

    /**
     * <p>
     * Registers a baseCode with its associated {@link Enum}.
     * </p>
     *
     * <p>
     * Checks if the given baseCode is already registered.
     * If the baseCode is already registered, an {@link IllegalArgumentException} is thrown.
     * Otherwise, the baseCode and enum name are added to the prefixMap.
     * </p>
     *
     * @param baseCode the unique baseCode to be registered
     * @param enumName the name of the {@link Enum} associated with the baseCode
     * @throws IllegalArgumentException if the baseCode is already registered
     */
    public static void register(final int baseCode, final String enumName) {
        final String specificEnumName = get(baseCode);

        if (specificEnumName == null || specificEnumName.equals(enumName)) {
            prefixMap.put(baseCode, enumName);
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
     * @return the {@link Enum} name associated with the given baseCode, or null if the prefix is not registered
     */
    public static String get(final int key) {
        return prefixMap.get(key);
    }
}
