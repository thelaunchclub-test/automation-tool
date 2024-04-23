package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonObject;
import com.commons.json.JsonMapper;
import com.commons.json.JsonWrapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * <p>
 * Manipulates JSON Array.
 *</p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public class JsonArrayImpl implements JsonArray, JsonWrapper {

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
     * @param index The index of the boolean value to be returned.
     * @return The integer value at the specified index.
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
     * @param index The index of the string value to be returned.
     * @return The string value at the specified index.
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
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a JSON array.
     */
    @Override
    public JsonArray getJsonArray(final int key) {
        return wrappedJsonArray((List<Object>) list.get(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a JSON object.
     */
    @Override
    public JsonObject getJsonObject(final int key) {
        return wrappedJsonObject((Map<String, Object>) list.get(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key, or null if the key is not found or the value is not a JSON array.
     */
    public JsonArray optJsonArray(final int key) {
        final Object object = list.get(key);

        if (Objects.nonNull(object)) {
            return wrappedJsonArray((List<Object>) object);
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key, or null if the key is not found or the value is not a JSON object.
     */
    @Override
    public JsonObject optJsonObject(final int key) {
        final Object object = list.get(key);

        if (Objects.nonNull(object)) {
            return wrappedJsonObject((Map<String, Object>) list.get(key));
        } else {
            return null;
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
     * @return The boolean value at the specified index, or null if the value is not an integer.
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
     * @param index The index of the string value to be returned.
     * @return The String value at the specified index, or null if the value is not an integer.
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
     * @param value The value to be appended.
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
     *{@inheritDoc}
     *
     * @param action The action to be performed for each element.
     * @throws NullPointerException if the specified action is null.
     */
    @Override
    public void forEach(final Consumer<? super Object> action) {
        list.forEach((Consumer<? super Object>) action);
    }

    /**
     * {@inheritDoc}
     *
     * @param list The list to be wrapped.
     * @return The wrapped {@link JsonArray}.
     */
    @Override
    public JsonArray wrappedJsonArray(final List<Object> list) {
        return new JsonArrayImpl(jsonMapper, list);
    }

    /**
     * {@inheritDoc}
     *
     * @param map The map to be wrapped.
     * @return The wrapped {@link JsonObject}.
     */
    @Override
    public JsonObject wrappedJsonObject(Map<String, Object> map) {
        return null;
    }
}