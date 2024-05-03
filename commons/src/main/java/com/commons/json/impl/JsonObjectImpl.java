package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonMapper;
import com.commons.json.JsonObject;
import com.commons.json.JsonWrapper;

import java.util.HashMap;
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

    private final Map<String, Object> map;
    private JsonMapper jsonMapper;

    JsonObjectImpl(final Map<String, Object> map) {
        this.map = map;
    }

    JsonObjectImpl(final JsonMapper jsonMapper, final Map<String, Object> map) {
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
        map.put(key, value);
    }

    /**
     * {@inheritDoc}
     *
     * @return The size of the JSON array.
     */
    public int size() {
        return map.size();
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
     * @return a Map containing the elements of this object
     */
    @Override
    public Map<String, Object> toMap() {
        return new HashMap<>(this.map);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key.
     */
    @Override
    public int getInt(final String key) {
        final Object object = fetchValue(key);

        return object instanceof Number number ? number.intValue() : Integer.parseInt((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated integer value is to be returned.
     * @return The integer value associated with the given key.
     */
    @Override
    public float getFloat(final String key) {
        final Object object = fetchValue(key);

        return object instanceof Number number ? number.floatValue() : Float.parseFloat((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated boolean value is to be returned.
     * @return The boolean value associated with the given key.
     */
    @Override
    public boolean getBoolean(final String key) {
        final Object object = fetchValue(key);

        return object instanceof Boolean ? (boolean) object : Boolean.parseBoolean((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated string value is to be returned.
     * @return The string value associated with the given key.
     */
    @Override
    public String getString(final String key) {
        final Object object = fetchValue(key);

        return object instanceof String ? (String) object : null;
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key.
     */
    @Override
    public JsonArray getJsonArray(final String key) {
        return wrappedJsonArray((List<Object>) fetchValue(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key.
     */
    @Override
    public JsonObject getJsonObject(final String key) {
        return wrappedJsonObject((Map<String, Object>) fetchValue(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated integer value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or the value is not an integer.
     * @return The integer value associated with the given key, or the default value if the key is not found or the value is not an integer.
     */
    @Override
    public int optInt(final String key, final int defaultValue) {
        return fetchValue(key) instanceof Number number ? number.intValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated float value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or the value is not a float.
     * @return The float value associated with the given key, or the default value if the key is not found or the value is not a float.
     */
    @Override
    public float optFloat(final String key, final float defaultValue) {
        return fetchValue(key) instanceof Number number ? number.floatValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated boolean value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or the value is not a boolean.
     * @return The boolean value associated with the given key, or the default value if the key is not found or the value is not a boolean.
     */
    @Override
    public boolean optBoolean(final String key, final boolean defaultValue) {
        final Object object = map.get(key);

        return (object instanceof Boolean) ? (boolean) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated string value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or the value is not a string.
     * @return The string value associated with the given key, or the default value if the key is not found or the value is not a string.
     */
    @Override
    public String optString(final String key, final String defaultValue) {
        final Object object = map.get(key);

        return (object instanceof String) ? (String) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON array is to be returned.
     * @return The JSON array associated with the given key, or null if the key is not found or the value is not a JSON array.
     */
    public JsonArray optJsonArray(final String key) {
        return wrappedJsonArray((List<Object>) fetchValue(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated JSON object is to be returned.
     * @return The JSON object associated with the given key, or null if the key is not found or the value is not a JSON object.
     */
    @Override
    public JsonObject optJsonObject(final String key) {
        return wrappedJsonObject((Map<String, Object>) fetchValue(key));
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
     * @param key The index of the object to check.
     * @return The object at the specified index if it is not null.
     * @throws NullPointerException if the object at the specified index is null.
     */
    private Object fetchValue(final String key) {
        final Object object = map.get(key);

        if (Objects.isNull(object)) {
            throw new NullPointerException("the key is invalid");
        }

        return object;
    }
}