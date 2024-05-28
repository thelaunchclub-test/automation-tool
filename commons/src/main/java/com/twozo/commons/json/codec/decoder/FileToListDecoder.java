package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.Value;

import java.io.File;
import java.util.List;

/**
 * <p>
 * The {@link FileToListDecoder} is responsible for decoding a JSON file into a
 * {@link List} of {@link Object}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@NonNull
public class FileToListDecoder implements Decoder<File, List<Object>> {

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a JSON file into a {@link List} of {@link Object}.
     *
     * @param file The JSON file to be decoded.
     * @return A {@link List} of {@link Object} parsed from the JSON file.
     * @throws RuntimeException if an error occurs during the decoding process.
     */
    @Override
    public List<Object> decode(final File file) {
        try {
            return objectMapper.readValue(file, List.class);
        } catch (Exception e) {
            throw new RuntimeException("Error decoding JSON file to List");  // TODO: Replace generic catch block with proper exception handling
        }
    }
}
