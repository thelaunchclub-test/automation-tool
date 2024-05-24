package com.twozo.commons.json.codec.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

/**
 * <p>
 * The {@link StringToListDecoder} is responsible for decoding a JSON string into a {@link List}.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
@Value
@NonNull
public class StringToListDecoder implements Decoder<String, List<Object>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a JSON string into a List.
     *
     * @param value The JSON string to be decoded.
     * @return A {@link List} of {@link Object parsed from the JSON string.
     * @throws {@link RuntimeException} if an error occurs during the decoding process.
     */
    @Override
    public List<Object> decode(final String value) {
        try {
            return objectMapper.readValue(value, List.class);
        } catch (Exception e) {
            throw new RuntimeException("Error decoding JSON string to List", e); // TODO: Replace generic catch block with proper exception handling
        }
    }
}
