package com.commons.json;

/**
 * <p>
 * Provides methods to put and retrieve data based on its data type within a JSON object.
 * Ensures type safety and handles null values appropriately.
 * Represents a list as a {@link JsonArray} and a map as a {@link JsonObject}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonObject jsonObject = new JsonObjectImpl();
 * jsonObject.put("name", "John Doe");
 * String name = jsonObject.getString("name");
 * }</pre>
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonObject extends JsonWrapper{

    /**
     * Associates the specified value with the specified key in this JSON object.
     *
     * @param key   The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     */
    void put(final String key, final Object value);

    /**
     * Returns the value associated with the specified key.
     *
     * @param key The key whose associated value is to be returned.
     * @return The value associated with the given key.
     */
    Object get(final String key);

    /**
     * Checks if the JSON object contains the specified key.
     *
     * @param key The key to check.
     * @return true if the JSON object contains the key, false otherwise.
     */
    boolean containsKey(final String key);

    /**
     * Returns the integer value associated with the specified key.
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not an integer.
     */
    int getInt(final String key);

    /**
     * Returns the boolean value associated with the specified key.
     *
     * @param key The key whose associated boolean value is to be returned.
     * @return The boolean value associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a boolean.
     */
    boolean getBoolean(final String key);

    /**
     * Returns the JSON array associated with the specified key.
     *
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a JSON array.
     */
    JsonArray getJsonArray(final String key);

    /**
     * Returns the JSON object associated with the specified key.
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a JSON object.
     */
    JsonObject getJsonObject(final String key);

    /**
     * Returns the string value associated with the specified key.
     *
     * @param key The key whose associated string value is to be returned.
     * @return The string value associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a string.
     */
    String getString(final String key);

    /**
     * Returns the integer value associated with the specified key, or null if the key is not found or the value is not an integer.
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key, or null if the key is not found or the value is not an integer.
     */
    Integer optInt(final String key);

    /**
     * Returns the integer value associated with the specified key, or null if the key is not found or the value is not an integer.
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key, or null if the key is not found or the value is not an integer.
     */
    String optString(final String key);

    /**
     * Returns the boolean value associated with the specified key, or null if the key is not found or the value is not a boolean.
     *
     * @param key The key whose associated boolean value is to be returned.
     * @return The boolean value associated with the given key, or null if the key is not found or the value is not a boolean.
     */
    Boolean optBoolean(final String key);

    /**
     * Returns the JSON array associated with the specified key, or null if the key is not found or the value is not a JSON array.
     *
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key, or null if the key is not found or the value is not a JSON array.
     */
    JsonArray optJsonArray(final String key);

    /**
     * Returns the JSON object associated with the specified key, or null if the key is not found or the value is not a JSON object.
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key, or null if the key is not found or the value is not a JSON object.
     */
    JsonObject optJsonObject(final String key);

    /**
     * Checks if the value associated with the specified key is null.
     *
     * @param key The key to check.
     * @return true if the value associated with the key is null, false otherwise.
     */
    boolean isNull(final String key);
}