package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.Value;

import java.io.File;
import java.util.Map;

/**
 * <p>
 * The {@link FileToMapDecoder} is responsible for decoding a JSON file into a {@link Map}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@NonNull
public class FileToMapDecoder implements Decoder<File, Map<String, Object>> {

    ObjectMapper objectMapper = new ObjectMapper();

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
