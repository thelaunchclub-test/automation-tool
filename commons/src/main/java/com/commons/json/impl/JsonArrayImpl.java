package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonMapper;
import com.commons.json.JsonObject;
import com.commons.json.JsonWrapper;

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

    private JsonMapper jsonMapper;
    private final List<Object> list;

    public JsonArrayImpl(final List<Object> objects) {
        this.list = objects;
    }

    public JsonArrayImpl(final JsonMapper jsonMapper, final List<Object> list) {
        this.jsonMapper = jsonMapper;
        this.list = list;
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index.
     * @throws NullPointerException if the value at the specified index is not an integer.
     */
    @Override
    public int getInt(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object) && object instanceof Integer) {
            return (int) object;
        } else {
            throw new NullPointerException("Null");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index.
     * @throws NullPointerException if the value at the specified index is not a boolean.
     */
    @Override
    public boolean getBoolean(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object) && object instanceof Boolean) {
            return (boolean) object;
        } else {
            throw new NullPointerException("Null");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index.
     * @throws NullPointerException if the value at the specified index is not a JSON array.
     */
    @Override
    public JsonArray getJsonArray(final int index) {
        return wrappedJsonArray((List<Object>) list.get(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index.
     * @throws NullPointerException if the value at the specified index is not a JSON object.
     */
    @Override
    public JsonObject getJsonObject(final int index) {
        return wrappedJsonObject((Map<String, Object>) list.get(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
     * @throws NullPointerException if the value at the specified index is not a string.
     */
    @Override
    public String getString(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object) && object instanceof String) {
            return (String) object;
        } else {
            throw new NullPointerException("Null");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the integer value to be returned.
     * @return The integer value at the specified index, or null if the value is not an integer.
     */
    @Override
    public Integer optInt(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object) && object instanceof Integer) {
            return (int) object;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the boolean value to be returned.
     * @return The boolean value at the specified index, or null if the value is not a boolean.
     */
    @Override
    public Boolean optBoolean(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object) && object instanceof Boolean) {
            return (boolean) object;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON array to be returned.
     * @return The JSON array at the specified index, or null if the value is not a JSON array.
     */
    public JsonArray optJsonArray(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object)) {
            return wrappedJsonArray((List<Object>) object);
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the JSON object to be returned.
     * @return The JSON object at the specified index, or null if the value is not a JSON object.
     */
    @Override
    public JsonObject optJsonObject(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object)) {
            return wrappedJsonObject((Map<String, Object>) list.get(index));
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index, or null if the value is not a string.
     */
    @Override
    public String optString(final int index) {
        final Object object = list.get(index);

        if (Objects.nonNull(object) && object instanceof String) {
            return (String) object;
        } else {
            return null;
        }
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
     * @param index The index to check.
     * @return true if the value at the specified index is null, false otherwise.
     */
    @Override
    public boolean isNull(final int index) {
        return Objects.isNull(list.get(index));
    }

    /**
     * {@inheritDoc}
     *
     * @param action The action to be performed for each element.
     * @throws NullPointerException if the specified action is null.
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
    public JsonObject wrappedJsonObject(Map<String, Object> map) {
        return new JsonObjectImpl(jsonMapper, map);
    }
}