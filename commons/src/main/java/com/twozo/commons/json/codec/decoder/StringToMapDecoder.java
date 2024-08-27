package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.commons.exception.status.CommonsErrorCode;

import lombok.NonNull;
import lombok.Value;

import java.util.Map;

/**
 * <p>
 * The {@link StringToMapDecoder} is responsible for decoding a JSON string into a {@link Map}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@NonNull
public class StringToMapDecoder implements Decoder<String, Map<String, Object>> {

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a JSON string into a {@link Map}.
     *
     * @param value The JSON string to be decoded.
     * @return A {@link Map} with keys and values parsed from the JSON string.
     */
    @Override
    public Map<String, Object> decode(final String value) {
        try {
            return objectMapper.readValue(value, Map.class);
        } catch (Exception e) {
            throw ErrorCode.get(CommonsErrorCode.FILE_NOT_FOUND);
        }
    }
}
