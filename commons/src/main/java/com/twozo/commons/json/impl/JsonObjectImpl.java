package com.twozo.commons.json.impl;

import com.twozo.commons.json.Json;
import com.twozo.commons.json.JsonArray;
import com.twozo.commons.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * Provides methods to put and retrieve data based on its data type within a {@link JsonObject}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonObject jsonObject = Json.object(file);
 * jsonObject.getJsonArray("children");
 * }</pre>
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see JsonObject
 */
@NonNull
public final class JsonObjectImpl implements JsonObject {

    private Map<String, Object> map;

    public JsonObjectImpl() {
    }

    public JsonObjectImpl(final Map<String, Object> map) {
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
     * @return The size of the {@link JsonObject}.
     */
    public int size() {
        return map.size();
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key to check.
     * @return true if the {@link JsonObject} contains the key, false otherwise.
     */
    @Override
    public boolean containsKey(final String key) {
        return map.containsKey(key);
    }

    /**
     * {@inheritDoc}
     *
     * @return a {@link Map} containing the elements of this object
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
        final Object object = getValue(key);

        return object instanceof Number number ? number.intValue() : Integer.parseInt((String) object);
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated float value is to be returned.
     * @return The float value associated with the given key.
     */
    @Override
    public float getFloat(final String key) {
        final Object object = getValue(key);

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
        final Object object = getValue(key);

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
        final Object object = getValue(key);

        return object instanceof String ? (String) object : null;
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated {@link JsonArray} is to be returned.
     * @return The {@link JsonArray} associated with the given key.
     */
    @Override
    public JsonArray getJsonArray(final String key) {
        return Json.array((List<Object>) getValue(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated {@link JsonObject} is to be returned.
     * @return The {@link JsonObject} associated with the given key.
     */
    @Override
    public JsonObject getJsonObject(final String key) {
        return Json.object((Map<String, Object>) getValue(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated integer value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not an integer.
     * @return The integer value associated with the given key, or the default value
     * if the key is not found or the value is not an integer.
     */
    @Override
    public int optInt(final String key, final int defaultValue) {
        return getValue(key) instanceof Number number ? number.intValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated float value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not a float.
     * @return The float value associated with the given key, or the default value
     * if the key is not found or the value is not a float.
     */
    @Override
    public float optFloat(final String key, final float defaultValue) {
        return getValue(key) instanceof Number number ? number.floatValue() : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated boolean value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not a boolean.
     * @return The boolean value associated with the given key, or the default value
     * if the key is not found or the value is not a boolean.
     */
    @Override
    public boolean optBoolean(final String key, final boolean defaultValue) {
        final Object object = getValue(key);

        return (object instanceof Boolean) ? (boolean) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key          The key whose associated string value is to be returned.
     * @param defaultValue The default value to be returned if the key is not found or
     *                     the value is not a string.
     * @return The string value associated with the given key, or the default value
     * if the key is not found or the value is not a string.
     */
    @Override
    public String optString(final String key, final String defaultValue) {
        final Object object = getValue(key);

        return (object instanceof String) ? (String) object : defaultValue;
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated {@link JsonArray} is to be returned.
     * @return The {@link JsonArray} associated with the given key, or
     * null if the key is not found or the value is not a {@link JsonArray}.
     */
    public JsonArray optJsonArray(final String key) {
        return Json.array((List<Object>) getValue(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key whose associated {@link JsonObject} is to be returned.
     * @return The {@link JsonObject} associated with the given key, or
     * null if the key is not found or the value is not a {@link JsonObject}.
     */
    @Override
    public JsonObject optJsonObject(final String key) {
        return Json.object((Map<String, Object>) getValue(key));
    }

    /**
     * Checks if the object at the specified index is not null.
     *
     * @param key The index of the object to check.
     * @return The object at the specified index if it is not null.
     * @throws NullPointerException if the object at the specified index is null.
     */
    private Object getValue(final String key) {
        final Object object = map.get(key);

        if (Objects.isNull(object)) {
            throw new NullPointerException("the key is invalid"); // TODO: Replace generic catch block with proper exception handling
        }

        return object;
    }
}