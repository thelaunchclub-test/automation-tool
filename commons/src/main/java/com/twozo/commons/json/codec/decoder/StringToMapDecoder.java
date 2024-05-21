package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * <p>
 * The {@link StringToMapDecoder} is responsible for decoding a JSON string into a {@link Map}.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public class StringToMapDecoder implements Decoder<String, Map<String, Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a JSON string into a Map.
     *
     * @param value The JSON string to be decoded.
     * @return A {@link Map} with keys and values parsed from the JSON string.
     * @throws RuntimeException if an error occurs during the decoding process.
     */
    @Override
    public Map<String, Object> decode(final String value) {
        try {
            return objectMapper.readValue(value, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Error decoding JSON string to Map"); // TODO: Replace generic catch block with proper exception handling
        }
    }
}
