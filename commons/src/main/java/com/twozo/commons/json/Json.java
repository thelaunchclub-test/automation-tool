package com.twozo.commons.json;

import com.twozo.commons.json.codec.decoder.Decoder;
import com.twozo.commons.json.codec.registry.DecoderRegistry;
import com.twozo.commons.json.impl.JsonArrayImpl;
import com.twozo.commons.json.impl.JsonObjectImpl;

import lombok.NonNull;
import lombok.Value;

import java.io.File;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * The {@link Json} serves as  a utility to handle and process JSON data.
 * Provides methods to accept input either as a JSON File or a JSON String and
 * converts the input data to a suitable representation like {@link JsonArray} or {@link JsonObject},
 * based on the specific requirements and structure of the provided data.
 * </p>
 *
 * <p>
 * Offers flexibility in processing both file-based and string-based JSON inputs,
 * allowing users to seamlessly convert and manipulate JSON data as per their needs.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonArray jsonArray = Json.array(new File("data.json"));
 * jsonArray.getInt(1);
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@NonNull
public class Json {

    private static final DecoderRegistry registry = new DecoderRegistry();

    private Json() {
    }

    /**
     * <p>
     * Converts a JSON string representing an array into a {@link JsonArray} object.
     * </p>
     *
     * @param value The JSON string.
     * @return The {@link JsonArray} object containing the decoded array.
     */
    public static JsonArray array(final String value) {
        final Decoder<String, Object> decoder = registry.get(String.class);

        return new JsonArrayImpl((List<Object>) decoder.decode(value));
    }

    /**
     * <p>
     * Converts a JSON string representing an object into a {@link JsonObject} object.
     * </p>
     *
     * @param value The JSON string.
     * @return The {@link JsonObject} object containing the decoded object.
     */
    public static JsonObject object(final String value) {
        final Decoder<String, Object> decoder = registry.get(String.class);

        return new JsonObjectImpl((Map<String, Object>) decoder.decode(value));
    }

    /**
     * <p>
     * Converts a JSON file representing an array into a {@link JsonArray} object.
     * </p>
     *
     * @param file The JSON file.
     * @return The {@link JsonArray} object containing the decoded array.
     */
    public static JsonArray array(final File file) {
        final Decoder<File, Object> decoder = registry.get(File.class);

        return new JsonArrayImpl((List<Object>) decoder.decode(file));
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
        final Decoder<File, Object> decoder = registry.get(File.class);

        return new JsonObjectImpl((Map<String, Object>) decoder.decode(file));
    }

    /**
     * Converts a {@link List} of objects into a {@link JsonArray} .
     *
     * @param list The {@link List} of objects to be converted to a {@link JsonArray}.
     * @return A {@link JsonArray} containing the elements from the given {@link List}.
     */
    public static JsonArray array(final List<Object> list) {
        return new JsonArrayImpl(list);
    }

    /**
     * Converts a {@link Map} of key-value pairs into a {@link JsonObject} .
     *
     * @param map The {@link Map} containing key-value pairs to be converted to a {@link JsonObject}.
     * @return A {@link JsonObject} containing the key-value pairs from the given {@link Map}.
     */
    public static JsonObject object(final Map<String, Object> map) {
        return new JsonObjectImpl(map);
    }
}
