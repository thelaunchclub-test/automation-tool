package com.twozo.commons.json;

import java.util.List;
import java.util.function.Consumer;

/**
 * The {@code JsonArray} defines operations for manipulating {@link JsonArray}.
 * Provides methods to access and manipulate elements within the array.
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonArray jsonArray = Json.array(file));
 * jsonArray.getString(2);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface JsonArray {

    /**
     * <p>
     * Puts the specified value to the end of the {@link JsonArray}.
     * </p>
     *
     * @param value The value to be added to the array.
     */
    void put(final Object value);

    /**
     * <p>
     * Returns the size of the {@link JsonArray}.
     * </p>
     *
     * @return The size of the {@link JsonArray}.
     */
    int size();

    /**
     * <p>
     * Converts the elements of this object into a {@link List} of Objects.
     * </p>
     *
     * @return a List containing the elements of this object
     */
    List<Object> toList();

    /**
     * <p>
     * Returns the integer value at the specified index in the {@link JsonArray}.
     * </p>
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index.
     */
    int getInt(final int index);

    /**
     * <p>
     * Returns the float value at the specified index in the {@link JsonArray}.
     * </p>
     *
     * @param index The index of the float value to be returned.
     * @return The float value at the specified index.
     */
    float getFloat(final int index);

    /**
     * <p>
     * Returns the boolean value at the specified index in the {@link JsonArray}.
     * </p>
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index.
     */
    boolean getBoolean(final int index);

    /**
     * <p>
     * Returns the string value at the specified index in the {@link JsonArray}.
     * </p>
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
     */
    String getString(final int index);

    /**
     * <p>
     * Returns the {@link JsonArray} at the specified index in the {@link JsonArray}.
     * </p>
     *
     * @param index The index of the {@link JsonArray} to be returned.
     * @return The {@link JsonArray} at the specified index.
     */
    JsonArray getJsonArray(final int index);

    /**
     * <p>
     * Returns the {@link JsonObject} at the specified index in the {@link JsonArray}.
     * </p>
     *
     * @param index The index of the {@link JsonObject} to be returned.
     * @return The {@link JsonObject} at the specified index.
     */
    JsonObject getJsonObject(final int index);

    /**
     * <p>
     * Returns the integer value at the specified index in the {@link JsonArray},
     * If the value is not present or not an integer, it returns a default value.
     * </p>
     *
     * @param index The index of the integer value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not an integer.
     * @return The integer value at the specified index, If the value is not present or not an integer,
     * Returns a default value.
     */
    int optInt(final int index, final int defaultValue);

    /**
     * <p>
     * Returns the float value at the specified index in the {@link JsonArray},
     * If the value is not present or not a float, it returns a default value.
     * </p>
     *
     * @param index The index of the float value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not a float.
     * @return The float value at the specified index, If the value is not present or not a float,
     * Returns a default value.
     */
    float optFloat(final int index, final float defaultValue);

    /**
     * <p>
     * Returns the boolean value at the specified index in the {@link JsonArray},
     * If the value is not present or not a boolean, it returns a default value.
     * </p>
     *
     * @param index The index of the boolean value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not a boolean.
     * @return The boolean value at the specified index, If the value is not present or not a boolean,
     * Returns a default value.
     */
    boolean optBoolean(final int index, final boolean defaultValue);

    /**
     * <p>
     * Returns the string value at the specified index in the {@link JsonArray},
     * If the value is not present or not a string, it returns a default value.
     * </p>
     *
     * @param index The index of the string value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not a string.
     * @return The string value at the specified index, If the value is not present or not a string,
     * Returns a default value.
     */
    Object optString(final int index, final String defaultValue);

    /**
     * <p>
     * Returns the {@link JsonArray} at the specified index in the {@link JsonArray},
     * or null if the value is not present.
     * </p>
     *
     * @param index The index of the {@link JsonArray} to be returned.
     * @return The {@link JsonArray} at the specified index, or null if the value is not present.
     */
    JsonArray optJsonArray(final int index);

    /**
     * <p>
     * Returns the {@link JsonObject} at the specified index in the {@link JsonArray},
     * or null if the value is not present.
     * </p>
     *
     * @param index The index of the {@link JsonObject} to be returned.
     * @return The {@link JsonObject} at the specified index, or null if the value is not present.
     */
    JsonObject optJsonObject(final int index);

    /**
     * <p>
     * Performs the given action for each element of the JSON array until all elements
     * have been processed or the action throws an exception.
     * The action receives an element from the array as a parameter.
     * </p>
     *
     * @param action The action to be performed for each element.
     */
    void forEach(final Consumer<? super Object> action);
}
