package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.commons.exception.status.CommonsErrorCode;

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
     */
    @Override
    public Map<String, Object> decode(final File file) {
        try {
            return objectMapper.readValue(file, Map.class);
        } catch (Exception exception) {
            throw ErrorCode.get(CommonsErrorCode.FILE_NOT_FOUND);
        }
    }
}
