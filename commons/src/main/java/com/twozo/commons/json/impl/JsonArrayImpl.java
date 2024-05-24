package com.twozo.commons.json.impl;

import com.twozo.commons.json.Json;
import com.twozo.commons.json.JsonArray;
import com.twozo.commons.json.JsonObject;
import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * @author petchimuthu
 * @version 1.0
 * @see JsonArray
 */
@NonNull
public final class JsonArrayImpl implements JsonArray {

    private List<Object> list;

    public JsonArrayImpl() {
    }

    public JsonArrayImpl(final List<Object> objects) {
        this.list = objects;
    }

    /**
     * {@inheritDoc}
     *
     * @param value The value to be added to the array.
     */
    @Override
    public void put(final Object value) {
        list.add(value);
    }

    /**
     * {@inheritDoc}
     *
     * @return The size of the {@link JsonArray}.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * {@inheritDoc}
     *
     * @return a List containing the elements of this object.
     */
    @Override
    public List<Object> toList() {
        return new ArrayList<>(this.list);
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index.
     */
    @Override
    public int getInt(final int index) {
        final Object object = getValue(index);

        return object instanceof Number number ? number.intValue() : Integer.parseInt((String) object);
    }

    /**
     * Returns the float value at the specified index in the JSON array.
     *
     * @param index The index of the float value to be returned.
     * @return The float value at the specified index.
     */
    @Override
    public float getFloat(final int index) {
        final Object object = getValue(index);

        return object instanceof Number number ? number.floatValue() : Float.parseFloat((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index.
     */
    @Override
    public boolean getBoolean(final int index) {
        final Object object = getValue(index);

        return object instanceof Boolean ? (boolean) object : Boolean.parseBoolean((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
     */
    @Override
    public String getString(final int index) {
        final Object object = getValue(index);

        return object instanceof String ? (String) object : null;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the {@link JsonArray} to be returned.
     * @return The {@link JsonArray} at the specified index.
     */
    @Override
    public JsonArray getJsonArray(final int index) {
        return Json.array((List<Object>) getValue(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the {@link JsonObject} to be returned.
     * @return The {@link JsonObject}t at the specified index.
     */
    @Override
    public JsonObject getJsonObject(final int index) {
        return Json.object((Map<String, Object>) getValue(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the integer value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not an integer.
     * @return The integer value at the specified index, If the value is not present or not an integer,
     * Returns a default value.
     */
    @Override
    public int optInt(final int index, final int defaultValue) {
        return getValue(index) instanceof Number number ? number.intValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the float value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not a float.
     * @return The float value at the specified index, If the value is not present or not a float,
     * Returns a default value.
     */
    @Override
    public float optFloat(final int index, final float defaultValue) {
        return getValue(index) instanceof Number number ? number.floatValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the boolean value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not a boolean.
     * @return The boolean value at the specified index, If the value is not present or not a boolean,
     * Returns a default value.
     */
    @Override
    public boolean optBoolean(final int index, final boolean defaultValue) {
        final Object object = getValue(index);

        return (object instanceof Boolean) ? (boolean) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the string value to be returned.
     * @param defaultValue The default value to be returned if the value is not present or not a string.
     * @return The string value at the specified index, If the value is not present or not a string,
     * Returns a default value.
     */
    @Override
    public String optString(final int index, final String defaultValue) {
        final Object object = getValue(index);

        return (object instanceof String) ? (String) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the {@link JsonArray} to be returned.
     * @return The {@link JsonArray} at the specified index, or null if the value is not present.
     */
    @Override
    public JsonArray optJsonArray(final int index) {
        return Json.array((List<Object>) get(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the {@link JsonObject} to be returned.
     * @return The {@link JsonObject} at the specified index, or null if the value is not present.
     */
    @Override
    public JsonObject optJsonObject(final int index) {
        return Json.object((Map<String, Object>) get(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param action The action to be performed for each element.
     */
    @Override
    public void forEach(final Consumer<? super Object> action) {
        list.forEach(action);
    }

    /**
     * Returns the object at the specified index.
     *
     * @param index The index of the object to check.
     * @return The object at the specified index if it is not null.
     * @throws NullPointerException if the object at the specified index is null.
     */
    private Object getValue(final int index) {
        final Object object = list.get(index);

        if (Objects.isNull(object)) {
            throw new NullPointerException("the key is invalid"); // TODO: Replace generic catch block with proper exception handling
        }

        return object;
    }

    /**
     * Retrieves the element at the specified index in the list.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index, or null if the index is out of range.
     */
    private Object get(int index) {
        return list.get(index);
    }
}
