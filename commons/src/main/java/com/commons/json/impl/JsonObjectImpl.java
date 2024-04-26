package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonMapper;
import com.commons.json.JsonObject;
import com.commons.json.JsonWrapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
 * @see JsonObject
 */
final class JsonObjectImpl implements JsonObject, JsonWrapper {

    private JsonMapper jsonMapper;

    private final Map<String, Object> map;

    public JsonObjectImpl(final Map<String, Object> map) {
        this.map = map;
    }

    public JsonObjectImpl(final JsonMapper jsonMapper, final Map<String, Object> map) {
        this.jsonMapper = jsonMapper;
        this.map = map;
    }

    /**
     * {@inheritDoc}
     *
     * @param key   The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     */
    @Override
    public void put(final String key, final Object value) {
        map.put(key, check(value));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated value is to be returned.
     * @return The value at the specified index
     */
    @Override
    public Object get(final String key) {
        return map.get(key);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key to check.
     * @return true if the JSON object contains the key, false otherwise.
     */
    @Override
    public boolean containsKey(final String key) {
        return map.containsKey(key);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key.
     * throws NullPointerException if the key is not found or the value is not an integer.
     */
    @Override
    public int getInt(final String key) {
        final Object object = map.get(key);

        if (Objects.nonNull(object) && object instanceof Integer) {
            return (int) object;
        } else {
            throw new NullPointerException("Null");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated boolean value is to be returned.
     * @return The boolean value associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a boolean.
     */
    @Override
    public boolean getBoolean(final String key) {
        final Object object = map.get(key);

        if (Objects.nonNull(object) && object instanceof Boolean) {
            return (boolean) object;
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
    public JsonArray getJsonArray(final String key) {

        if (Objects.nonNull(map.get(key))) {

            return wrappedJsonArray((List<Object>) map.get(key));
        } else {
            throw new NullPointerException("The Key is invalid");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated string value is to be returned.
     * @return The string value associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a string.
     */
    @Override
    public String getString(final String key) {
        final Object object = map.get(key);

        if (Objects.nonNull(object) && object instanceof String) {
            return (String) object;
        } else {
            throw new NullPointerException("Null");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key, or null if the key is not found or the value is not an integer.
     */
    @Override
    public Integer optInt(final String key) {
        final Object object = map.get(key);

        if (Objects.nonNull(object) && object instanceof Integer) {
            return (Integer) object;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key, or null if the key is not found or the value is not an integer.
     */
    @Override
    public String optString(final String key) {
        final Object object = map.get(key);

        if (Objects.nonNull(object) && object instanceof String) {
            return (String) object;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated boolean value is to be returned.
     * @return The boolean value associated with the given key, or null if the key is not found or the value is not a boolean.
     */
    @Override
    public Boolean optBoolean(final String key) {
        final Object object = map.get(key);

        if (Objects.nonNull(object) && object instanceof Boolean) {
            return (Boolean) object;
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
    public JsonObject optJsonObject(final String key) {

        if (Objects.nonNull(map.get(key))) {

            return wrappedJsonObject((Map<String, Object>) map.get(key));
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key to check.
     * @return true if the value associated with the key is null, false otherwise.
     */
    @Override
    public boolean isNull(final String key) {
        return Objects.isNull(map.get(key));
    }

    /**
     * Checks if the provided object is not null.
     *
     * @param object The object to be checked.
     * @return The object if not null.
     * @throws NullPointerException If the object is null.
     */
    private Object check(final Object object) {
        if (Objects.nonNull(object)) {
            return object;
        } else {
            throw new NullPointerException("");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key.
     * @throws NullPointerException if the key is not found or the value is not a JSON object.
     */
    @Override
    public JsonObject getJsonObject(final String key) {

        if (Objects.nonNull(map.get(key))) {

            return wrappedJsonObject((Map<String, Object>) map.get(key));
        } else {
            throw new NullPointerException("The Key is invalid");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key, or null if the key is not found or the value is not a JSON array.
     */
    public JsonArray optJsonArray(final String key) {
        if (Objects.nonNull(map.get(key))) {

            return wrappedJsonArray((List<Object>) map.get(key));
        } else {
            return null;
        }
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
}