package com.commons.json;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * encodes and decodes JSON data.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonMapper {

    /**
     * Encodes the given object as a JSON string.
     *
     * @param classType The object to be encoded.
     * @return The JSON string representation of the object.
     */
    String encodeAsString(final String classType);

    /**
     * Encodes the given object as JSON bytes.
     *
     * @param classType The object to be encoded.
     * @return The JSON bytes representation of the object.
     */
    byte[] encodeAsByte(final String classType);

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