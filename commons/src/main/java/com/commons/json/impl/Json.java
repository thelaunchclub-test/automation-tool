package com.commons.json.impl;

import com.commons.json.JsonArray;
import com.commons.json.JsonDecoder;
import com.commons.json.JsonObject;

import java.io.File;

/**
 * <p>
 * The {@code Json} serves as  a utility to handle and process JSON data.
 * It provides methods to accept input either as a JSON File or a JSON String and
 * converts the input data to a suitable representation like {@link  JsonArray} or {@link JsonObject},
 * based on the specific requirements and structure of the provided data.
 * </p>
 *
 * <p>
 * This class offers flexibility in processing both file-based and string-based JSON inputs,
 * allowing users to seamlessly convert and manipulate JSON data as per their needs.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonObject jsonData = json.object(new File("data.json"));
 * }</pre>
 * </p>
 * <p>
 *
 * @author petchimuthu2015
 * @version 1.0
 */
public final class Json {

    private static final JsonDecoder JSON_MAPPER = new JsonDecoderImpl();

    /**
     * <p>
     * Converts a JSON string representing an array into a {@link JsonArray} object.
     * </p>
     *
     * @param value The JSON string representing an array.
     * @return The {@link JsonArray} object containing the decoded array.
     */
    public static JsonArray array(final String value) {
        return new JsonArrayImpl(JSON_MAPPER.decodeAsArray(value));
    }

    /**
     * <p>
     * Converts a JSON string representing an object into a {@link JsonObject} object.
     * </p>
     *
     * @param value The JSON string representing an object.
     * @return The {@link JsonObject} object containing the decoded object.
     */
    public static JsonObject object(final String value) {
        return new JsonObjectImpl(JSON_MAPPER.decodeAsObject(value));
    }

    /**
     * <p>
     * Converts a JSON file representing an object into a {@link JsonObject} object.
     * </p>
     *
     * @param file The JSON file representing an object.
     * @return The {@link JsonObject} object containing the decoded object.
     */
    public static JsonObject object(final File file) {
        return new JsonObjectImpl(JSON_MAPPER.decodeAsObject(file));
    }

    /**
     * <p>
     * Converts a JSON file representing an array into a {@link JsonArray} object.
     * </p>
     *
     * @param file The JSON file representing an array.
     * @return The {@link JsonArray} object containing the decoded array.
     */
    public static JsonArray array(final File file) {
        return new JsonArrayImpl(JSON_MAPPER.decodeAsArray(file));
    }
}
