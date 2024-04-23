package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonObject;
import com.commons.json.JsonMapper;

import java.io.File;


/**
 * <p>
 * Converts JSON String to JSON Arrays and JSON Objects.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public class Json {

    private static final JsonMapper JSON_MAPPER = new JsonMapperImpl();

    /**
     * Converts a JSON string representing an array into a {@link JsonArray} object.
     *
     * @param value The JSON string representing an array.
     * @return The {@link JsonArray} object containing the decoded array.
     */
    public static JsonArray array(final String value) {
        return new JsonArrayImpl(JSON_MAPPER.decodeAsArray(value));
    }

    /**
     * Converts a JSON string representing an object into a {@link JsonObject} object.
     *
     * @param value The JSON string representing an object.
     * @return The {@link JsonObject} object containing the decoded object.
     */
    public static JsonObject object(final String value) {
        return new JsonObjectImpl(JSON_MAPPER.decodeAsObject(value));
    }

    /**
     * Converts a JSON file representing an object into a {@link JsonObject} object.
     *
     * @param file The JSON file representing an object.
     * @return The {@link JsonObject} object containing the decoded object.
     */
    public static JsonObject object(final File file) {
        return new JsonObjectImpl(JSON_MAPPER.decodeAsObject(file));
    }

    /**
     * Converts a JSON file representing an array into a {@link JsonArray} object.
     *
     * @param file The JSON file representing an array.
     * @return The {@link JsonArray} object containing the decoded array.
     */
    public static JsonArray array(final File file) {
        return new JsonArrayImpl(JSON_MAPPER.decodeAsArray(file));
    }
}
