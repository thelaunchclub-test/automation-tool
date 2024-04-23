package com.commons.json;

import org.apache.poi.ss.formula.functions.T;

import java.util.function.Consumer;

/**
 * <p>
 * Manipulates JSON Array.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonArray {

    /**
     * Returns the integer value at the specified index.
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index.
     * @throws NullPointerException if the value at the specified index is not an integer.
     */
    int getInt(final int index);

    /**
     * Returns the boolean value at the specified index.
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index.
     * @throws NullPointerException if the value at the specified index is not a boolean.
     */
    boolean getBoolean(final int index);

    /**
     * Returns the JSON array at the specified index.
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index.
     * @throws NullPointerException if the value at the specified index is not a JSON array.
     */
    JsonArray getJsonArray(final int index);

    /**
     * Returns the JSON object at the specified index.
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index.
     * @throws NullPointerException if the value at the specified index is not a JSON object.
     */
    JsonObject getJsonObject(final int index);

    /**
     * Returns the string value at the specified index.
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
     * @throws NullPointerException if the value at the specified index is not a string.
     */
    String getString(final int index);

    /**
     * Returns the integer value at the specified index, or null if the value is not an integer.
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index, or null if the value is not an integer.
     */
    Object optInt(final int index);

    /**
     * Returns the boolean value at the specified index, or null if the value is not a boolean.
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index, or null if the value is not a boolean.
     */
    Object optBoolean(final int index);

    /**
     * Returns the JSON array at the specified index, or null if the value is not a JSON array.
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index, or null if the value is not a JSON array.
     */
    Object optJsonArray(final int index);

    /**
     * Returns the JSON object at the specified index, or null if the value is not a JSON object.
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index, or null if the value is not a JSON object.
     */
    Object optJsonObject(final int index);

    /**
     * Returns the string value at the specified index, or null if the value is not a string.
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index, or null if the value is not a string.
     */
    Object optString(final int index);

    /**
     * Appends the specified value to the end of the JSON array.
     *
     * @param value The value to be appended.
     */
    void put(final Object value);

    /**
     * Checks if the value at the specified index is null.
     *
     * @param index The index to check.
     * @return true if the value at the specified index is null, false otherwise.
     */
    boolean isNull(final int index);

    /**
     * Performs the given action for each element of the JSON array until all elements have been processed or the action throws an exception.
     * The action receives an element from the array as a parameter.
     *
     * @param action The action to be performed for each element.
     * @throws NullPointerException if the specified action is null.
     */
    void forEach(Consumer<? super T> action);
}
