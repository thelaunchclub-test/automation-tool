
package com.twozo.commons.json;

import java.util.Map;

/**
 * <p>
 * Provides methods to put and retrieve data based on its data type within a {@link JsonObject}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonObject jsonObject = Json.object(file);
 * jsonObject.getJsonArray("children");
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface JsonObject {

    /**
     * <p>
     * Puts the specified value with the specified key in this {@link JsonObject}.
     * </p>
     *
     * @param key   The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     */
    void put(final String key, final Object value);

    /**
     * <p>
     * Returns the size of the {@link JsonObject}.
     * </p>
     *
     * @return The size of the {@link JsonObject}.
     */
    int size();

    /**
     * <p>
     * Checks if the {@link JsonObject} contains the specified key.
     * </p>
     *
     * @param key The key to check.
     * @return true if the {@link JsonObject} contains the key, false otherwise.
     */
    boolean containsKey(final String key);

    /**
     * <p>
     * Converts the elements of the {@link JsonObject} into a {@link Map} where keys are strings
     * and values are objects.
     * </p>
     *
     * @return a {@link Map} containing the elements of this object
     */
    Map<String, Object> toMap();

    /**
     * <p>
     * Returns the integer value associated with the specified key.
     * </p>
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key.
     */
    int getInt(final String key);

    /**
     * <p>
     * Returns the long value for the given key.
     * </p>
     *
     * @param key Represents the key to get the long value
     * @return the value
     */
    Long getLong(final String key);

    /**
     * <p>
     * Returns the float value associated with the specified key.
     * </p>
     *
     * @param key The key whose associated float value is to be returned.
     * @return The float value associated with the given key.
     */
    float getFloat(final String key);

    /**
     * <p>
     * Returns the boolean value associated with the specified key.
     * </p>
     *
     * @param key The key whose associated boolean value is to be returned.
     * @return The boolean value associated with the given key.
     */
    boolean getBoolean(final String key);

    /**
     * <p>
     * Returns the string value associated with the specified key.
     * </p>
     *
     * @param key The key whose associated string value is to be returned.
     * @return The string value associated with the given key.
     */
    String getString(final String key);

    /**
     * <p>
     * Returns the {@link JsonArray} associated with the specified key.
     * </p>
     *
     * @param key The key whose associated {@link JsonArray} is to be returned.
     * @return The {@link JsonArray} associated with the given key.
     */
    JsonArray getJsonArray(final String key);

    /**
     * <p>
     * Returns the {@link JsonObject} associated with the specified key.
     * </p>
     *
     * @param key The key whose associated {@link JsonObject} is to be returned.
     * @return The {@link JsonObject} associated with the given key.
     */
    JsonObject getJsonObject(final String key);

    /**
     * <p>
     * Returns the integer value associated with the specified key, or the default value
     * if the key is not found or the value is not an integer.
     * </p>
     *
     * @param key          The key whose associated integer value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not an integer.
     * @return The integer value associated with the given key, or the default value
     * if the key is not found or the value is not an integer.
     */
    int optInt(final String key, final int defaultValue);

    /**
     * <p>
     * Returns the float value associated with the specified key, or the default value
     * if the key is not found or the value is not a float.
     * </p>
     *
     * @param key          The key whose associated float value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not a float.
     * @return The float value associated with the given key, or the default value
     * if the key is not found or the value is not a float.
     */
    float optFloat(final String key, final float defaultValue);

    /**
     * <p>
     * Returns the boolean value associated with the specified key, or the default value
     * if the key is not found or the value is not a boolean.
     * </p>
     *
     * @param key          The key whose associated boolean value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not a boolean.
     * @return The boolean value associated with the given key, or the default value
     * if the key is not found or the value is not a boolean.
     */
    boolean optBoolean(final String key, final boolean defaultValue);

    /**
     * <p>
     * Returns the string value associated with the specified key, or the default value
     * if the key is not found or the value is not a string.
     * </p>
     *
     * @param key          The key whose associated string value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not a string.
     * @return The string value associated with the given key, or the default value
     * if the key is not found or the value is not a string.
     */
    String optString(final String key, final String defaultValue);

    /**
     * <p>
     * Returns the {@link JsonArray} associated with the specified key, or
     * null if the key is not found or the value is not a {@link JsonArray}.
     * </p>
     *
     * @param key The key whose associated {@link JsonArray} is to be returned.
     * @return The {@link JsonArray} associated with the given key, or
     * null if the key is not found or the value is not a {@link JsonArray}.
     */
    JsonArray optJsonArray(final String key);

    /**
     * <p>
     * Returns the {@link JsonObject} associated with the specified key, or
     * null if the key is not found or the value is not a {@link JsonObject}.
     * </p>
     *
     * @param key The key whose associated {@link JsonObject} is to be returned.
     * @return The {@link JsonObject} associated with the given key, or
     * null if the key is not found or the value is not a {@link JsonObject}.
     */
    JsonObject optJsonObject(final String key);
}

