package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.commons.exception.status.CommonsErrorCode;

import lombok.NonNull;
import lombok.Value;

import java.util.List;

/**
 * <p>
 * The {@link StringToListDecoder} is responsible for decoding a JSON string into a {@link List}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@Value
@NonNull
public class StringToListDecoder implements Decoder<String, List<Object>> {

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a JSON string into a {@link List} of {@link Object}.
     *
     * @param value The JSON string to be decoded.
     * @return A {@link List} of {@link Object parsed from the JSON string.
     */
    @Override
    public List<Object> decode(final String value) {
        try {
            return objectMapper.readValue(value, List.class);
        } catch (Exception e) {
            throw ErrorCode.get(CommonsErrorCode.FILE_NOT_FOUND);
        }
    }
}
