package com.commons.json;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Provides methods to encode and decode JSON data. It offers functionalities to convert
 * JSON files or JSON strings to String or byte[], and transforms Strings into lists or maps as required.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonMapper jsonMapper = new JsonMapperImpl();
 * String jsonString = "{\"key\": \"value\"}";
 * Map<String, Object> decodedObject = jsonMapper.decodeAsObject(jsonString);
 * }</pre>
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonMapper {

    /**
     * Decodes the given JSON string to a Map object.
     *
     * @param json The JSON string to be decoded.
     * @return The Map representation of the JSON string.
     */
    Map<String, Object> decodeAsObject(final String json);

    /**
     * Decodes the given JSON string to a List object.
     *
     * @param json The JSON string to be decoded.
     * @return The List representation of the JSON string.
     */
    List<Object> decodeAsArray(final String json);

    /**
     * Decodes the given JSON file to a Map object.
     *
     * @param file The JSON file to be decoded.
     * @return The Map representation of the JSON file.
     */
    Map<String, Object> decodeAsObject(final File file);

    /**
     * Decodes the given JSON file to a List object.
     *
     * @param file The JSON file to be decoded.
     * @return The List representation of the JSON file.
     */
    List<Object> decodeAsArray(final File file);
}
