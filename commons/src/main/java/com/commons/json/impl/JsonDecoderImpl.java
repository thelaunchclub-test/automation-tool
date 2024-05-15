package com.commons.json.impl;

import com.commons.json.JsonDecoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

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
final class JsonDecoderImpl implements JsonDecoder {

    private final ObjectMapper objectMapper;

    JsonDecoderImpl() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * {@inheritDoc}
     *
     * @param json The JSON string to be decoded.
     * @return The {@link Map} representation of the JSON string.
     */
    @Override
    public Map<String, Object> decodeAsObject(final String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param json The JSON string to be decoded.
     * @return The {@link List} representation of the JSON string.
     */
    @Override
    public List<Object> decodeAsArray(final String json) {
        try {
            return objectMapper.readValue(json, List.class);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param file The JSON file to be decoded.
     * @return The {@link Map} representation of the JSON file.
     * @throws IOException if there's an issue reading the file.
     */
    @Override
    public Map<String, Object> decodeAsObject(final File file) {
        try {
            return objectMapper.readValue(file, Map.class);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param file The JSON file to be decoded.
     * @return The {@link List} representation of the JSON file.
     * @throws IOException if there's an issue reading the file.
     */
    @Override
    public List<Object> decodeAsArray(final File file) {
        try {
            return objectMapper.readValue(file, List.class);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}