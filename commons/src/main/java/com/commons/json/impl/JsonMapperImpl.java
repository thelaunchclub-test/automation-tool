package com.commons.json.impl;

import com.commons.json.JsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * encodes and decoded JSON data.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public class JsonMapperImpl implements JsonMapper {

    private final ObjectMapper objectMapper;

    public JsonMapperImpl() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * {@inheritDoc}
     *
     * @param classType The object to be encoded.
     * @return The JSON string representation of the object.
     */
    @Override
    public String encodeAsString(final String classType) {
        try {
            return objectMapper.writeValueAsString(classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e); // TODO: Implement custom exception
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param classType The object to be encoded.
     * @return The JSON bytes representation of the object.
     */
    @Override
    public byte[] encodeAsByte(final String classType) {
        try {
            return objectMapper.writeValueAsBytes(classType);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param json The JSON string to be decoded.
     * @return The Map representation of the JSON string.
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
     * @return The List representation of the JSON string.
     */
    @Override
    public List<Object> decodeAsArray(final String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param file The JSON file to be decoded.
     * @return The Map representation of the JSON file.
     * @throws IOException if there's an issue reading the file.
     */
    @Override
    public Map<String, Object> decodeAsObject(final File file) {
        try {
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param file The JSON file to be decoded.
     * @return The List representation of the JSON file.
     * @throws IOException if there's an issue reading the file.
     */
    @Override
    public List<Object> decodeAsArray(final File file) {
        try {
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
