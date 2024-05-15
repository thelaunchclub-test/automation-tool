package com.commons.json;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Provides methods to decode JSON data. Offers functionalities to convert
 * JSON files or JSON strings to String or byte[], and transforms Strings into lists or maps as required.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonDecoder jsonDecoder = new JsonDecoderImpl();
 * String jsonString = "{\"key\": \"value\"}";
 * Map<String, Object> decodedObject = jsonMapper.decodeAsObject(jsonString);
 * }</pre>
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonDecoder {

    /**
     * <p>
     * Decodes the given JSON string to a {@link Map} object.
     * </p>
     *
     * @param json The JSON string to be decoded.
     * @return The {@link Map} representation of the JSON string.
     */
    Map<String, Object> decodeAsObject(final String json);

    /**
     * <p>
     * Decodes the given JSON string to a {@link List} object.
     * </p>
     *
     * @param json The JSON string to be decoded.
     * @return The {@link List} representation of the JSON string.
     */
    List<Object> decodeAsArray(final String json);

    /**
     * <p>
     * Decodes the given JSON file to a {@link Map} object.
     * </p>
     *
     * @param file The JSON file to be decoded.
     * @return The {@link Map} representation of the JSON file.
     */
    Map<String, Object> decodeAsObject(final File file);

    /**
     * <p>
     * Decodes the given JSON file to a {@link List} object.
     * </p>
     *
     * @param file The JSON file to be decoded.
     * @return The {@link List} representation of the JSON file.
     */
    List<Object> decodeAsArray(final File file);
}
