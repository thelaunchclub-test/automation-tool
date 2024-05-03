package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonMapper;
import com.commons.json.JsonObject;
import com.commons.json.JsonWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * The {@code JsonArray} interface defines operations for manipulating JSON arrays.
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
 * @see JsonArray
 */
final class JsonArrayImpl implements JsonArray, JsonWrapper {

    private final List<Object> list;
    private JsonMapper jsonMapper;

    JsonArrayImpl(final List<Object> objects) {
        this.list = objects;
    }

    JsonArrayImpl(final JsonMapper jsonMapper, final List<Object> list) {
        this.jsonMapper = jsonMapper;
        this.list = list;
    }

    /**
     * {@inheritDoc}
     *
     * @param value The value to be added.
     */
    @Override
    public void put(final Object value) {
        list.add(value);
    }

    /**
     * {@inheritDoc}
     *
     * @return The size of the JSON array.
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
    public List<Object> toList(){
        return this.list;
    }
    /**
     * {@inheritDoc}
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index.
     */
    @Override
    public int getInt(final int index) {
        final Object object = isNonNull(index);

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
        final Object object = isNonNull(index);

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
        final Object object = isNonNull(index);

        return object instanceof Boolean  ? (boolean)object : Boolean.parseBoolean((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
     */
    @Override
    public String getString(final int index) {
        final Object object = isNonNull(index);

        return object instanceof String ? (String) object : null;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index.
     */
    @Override
    public JsonArray getJsonArray(final int index) {
        return wrappedJsonArray((List<Object>) isNonNull(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index.
     */
    @Override
    public JsonObject getJsonObject(final int index) {
        return wrappedJsonObject((Map<String, Object>) isNonNull(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index        The index of the integer value to be returned.
     * @param defaultValue The default value to be returned if the value is not an integer.
     * @return The integer value at the specified index, or the default value if the value is not an integer.
     */
    @Override
    public int optInt(final int index, final int defaultValue) {
        return isNonNull(index) instanceof Number number ? number.intValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index        The index of the float value to be returned.
     * @param defaultValue The default value to be returned if the value is not a float.
     * @return The float value at the specified index, or the default value if the value is not a float.
     */
    @Override
    public float optFloat(final int index, final float defaultValue) {
        return isNonNull(index) instanceof Number number ? number.floatValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index, or null if the value is not a boolean.
     */
    @Override
    public boolean optBoolean(final int index, final boolean defaultValue) {
        final Object object = isNonNull(index);

        return (object instanceof Boolean) ? (boolean) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index, or null if the value is not a string.
     */
    @Override
    public String optString(final int index, final String defaultValue) {
        final Object object = isNonNull(index);

        return (object instanceof String) ? (String) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index, or null if the value is not a JSON array.
     */
    @Override
    public JsonArray optJsonArray(final int index) {
        return wrappedJsonArray((List<Object>) isNonNull(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index, or null if the value is not a JSON object.
     */
    @Override
    public JsonObject optJsonObject(final int index) {
        return wrappedJsonObject((Map<String, Object>) isNonNull(index));
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
     * {@inheritDoc}
     *
     * @param list The List of Objects to wrap.
     * @return A JsonArray containing the wrapped list.
     */
    @Override
    public JsonArray wrappedJsonArray(final List<Object> list) {
        return new JsonArrayImpl(jsonMapper, list);
    }

    /**
     * {@inheritDoc}
     *
     * @param map The Map of key-value pairs to wrap.
     * @return A JsonObject containing the wrapped map.
     */
    @Override
    public JsonObject wrappedJsonObject(final Map<String, Object> map) {
        return new JsonObjectImpl(jsonMapper, map);
    }

    /**
     * Checks if the object at the specified index is not null.
     *
     * @param index The index of the object to check.
     * @return The object at the specified index if it is not null.
     * @throws NullPointerException if the object at the specified index is null.
     */
    private Object isNonNull(final int index) {
        final Object object = list.get(index);

        if (Objects.isNull(object)) {
            throw new NullPointerException("the key is invalid");
        }

        return object;
    }
}
