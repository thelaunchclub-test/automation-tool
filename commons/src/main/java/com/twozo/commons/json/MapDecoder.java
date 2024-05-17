package com.twozo.commons.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * <p>
 * The {@link Decoder} decodes JSON data into a {@link Map}.
 * </p>
 *
 * <p>
 * Provides the functionality to decode JSON data, whether it is provided as a {@link File}
 * or a {@link String}, into a {@link Map} of key-value pairs.
 * </p>
 */
public class MapDecoder implements Decoder<Map<String, Object>> {

    final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes the given object, which is either a JSON file or a JSON string,
     * into a {@link Map}.
     *
     * @param object The object to be decoded, which can be either a {@link File}
     *               containing JSON data or a JSON string.
     * @return A {@link Map} of key-value pairs decoded from the JSON data.
     * If an error occurs, an empty map is returned.
     */
    @Override
    public Map<String, Object> decode(final Object object) {
        try {
            return (object instanceof File) ?
                    objectMapper.readValue((File) object, Map.class) :
                    objectMapper.readValue((String) object, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}
