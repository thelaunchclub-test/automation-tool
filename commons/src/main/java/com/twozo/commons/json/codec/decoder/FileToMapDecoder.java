package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

/**
 * <p>
 * The {@link FileToMapDecoder} is responsible for decoding a JSON file into a {@link Map}.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public class FileToMapDecoder implements Decoder<File, Map<String, Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a JSON file into a {@link Map}.
     *
     * @param file The JSON file to be decoded.
     * @return A {@link Map} with keys and values parsed from the JSON file.
     * @throws RuntimeException if an error occurs during the decoding process.
     */
    @Override
    public Map<String, Object> decode(final File file) {
        try {
            return objectMapper.readValue(file, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Error decoding JSON file to Map", e); // TODO: Replace generic catch block with proper exception handling
        }
    }
}
