package com.twozo.commons.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * The {@link Decoder} decodes JSON data into a {@link List} of objects.
 * </p>
 *
 * <p>
 * Provides the functionality to decode JSON data, whether it is provided as a {@link File}
 * or a {@link String}, into a {@link List} of Java objects.
 * </p>
 */
public class ListDecoder implements Decoder<List<Object>> {

    final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes the given object, which is either a JSON file or a JSON string,
     * into a {@link List} of objects.
     *
     * @param object The object to be decoded, which can be either a {@link File}
     *               containing JSON data or a JSON string.
     * @return A {@link List} of Java objects decoded from the JSON data.
     * If an error occurs, an empty list is returned.
     */
    @Override
    public List<Object> decode(final Object object) {
        try {
            return (object instanceof File) ?
                    objectMapper.readValue((File) object, List.class) :
                    objectMapper.readValue((String) object, List.class);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
