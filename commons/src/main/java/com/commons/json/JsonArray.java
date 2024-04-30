package com.commons.json;

import java.util.function.Consumer;

/**
 * The {@code JsonArray} defines operations for manipulating JSON arrays.
 * It provides methods to access and manipulate elements within the array, offering
 * functionalities for type checking, handling null values, and wrapping data structures.
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonArray jsonArray = new JsonArrayImpl();
 * jsonArray.put("value");
 * String retrievedValue = jsonArray.getString(0);
 * }</pre>
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonArray extends JsonWrapper {

    /**
     * Adds the specified value to the end of the JSON array.
     *
     * @param value The value to be added to the array.
     */
    void put(final Object value);

    /**
     * Returns the value at the specified index in the JSON array.
     *
     * @param index The index of the value to be returned.
     * @return The value at the specified index.
     */
    Object get(final int index);

    /**
     * Returns the size of the JSON array.
     *
     * @return The size of the JSON array.
     */
    int size();

    /**
     * Returns the integer value at the specified index in the JSON array.
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index.
     */
    int getInt(final int index);

    /**
     * Returns the float value at the specified index in the JSON array.
     *
     * @param index The index of the float value to be returned.
     * @return The float value at the specified index.
     */
    float getFloat(final int index);

    /**
     * Returns the boolean value at the specified index in the JSON array.
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index.
     */
    boolean getBoolean(final int index);

    /**
     * Returns the string value at the specified index in the JSON array.
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
     */
    String getString(final int index);

    /**
     * Returns the JSON array at the specified index in the JSON array.
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index.
     * @throws NullPointerException if the value at the specified index is not a JSON array.
     */
    JsonArray getJsonArray(final int index);

    /**
     * Returns the JSON object at the specified index in the JSON array.
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index.
     * @throws NullPointerException if the value at the specified index is not a JSON object.
     */
    JsonObject getJsonObject(final int index);

    /**
     * Returns the integer value at the specified index in the JSON array, or a default value if the value is not an integer.
     *
     * @param index        The index of the integer value to be returned.
     * @param defaultValue The default value to be returned if the value is not an integer.
     * @return The integer value at the specified index, or the default value if the value is not an integer.
     */
    int optInt(final int index, final int defaultValue);

    /**
     * Returns the float value at the specified index in the JSON array, or a default value if the value is not a float.
     *
     * @param index        The index of the float value to be returned.
     * @param defaultValue The default value to be returned if the value is not a float.
     * @return The float value at the specified index, or the default value if the value is not a float.
     */
    float optFloat(final int index, final float defaultValue);

    /**
     * Returns the boolean value at the specified index in the JSON array, or a default value if the value is not a boolean.
     *
     * @param index        The index of the boolean value to be returned.
     * @param defaultValue The default value to be returned if the value is not a boolean.
     * @return The boolean value at the specified index, or the default value if the value is not a boolean.
     */
    boolean optBoolean(final int index, final boolean defaultValue);

    /**
     * Returns the string value at the specified index in the JSON array, or null if the value is not a string.
     *
     * @param index        The index of the string value to be returned.
     * @param defaultValue The default value to be returned if the value is not a string.
     * @return The string value at the specified index, or null if the value is not a string.
     */
    Object optString(final int index, final String defaultValue);

    /**
     * Returns the JSON array at the specified index in the JSON array, or null if the value is not a JSON array.
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index, or null if the value is not a JSON array.
     */
    Object optJsonArray(final int index);

    /**
     * Returns the JSON object at the specified index in the JSON array, or null if the value is not a JSON object.
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index, or null if the value is not a JSON object.
     */
    Object optJsonObject(final int index);

    /**
     * Performs the given action for each element of the JSON array until all elements have been processed or the action throws an exception.
     * The action receives an element from the array as a parameter.
     *
     * @param action The action to be performed for each element.
     * @throws NullPointerException if the specified action is null.
     */
    void forEach(Consumer<? super Object> action);
}
