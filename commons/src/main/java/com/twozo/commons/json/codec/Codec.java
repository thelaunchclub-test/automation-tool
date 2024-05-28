package com.twozo.commons.json.codec;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Defines methods for encoding and decoding objects.
 * </p>
 *
 * <p>
 * Converts {@link Object} of type T to a specific representation
 * of type R and vice versa. Converts JSON string or JSON file
 * into a {@link List} or {@link Map} based on the specific requirements.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public interface Codec<T, R> {

    /**
     * Encodes an object of type T into a representation of type R.
     *
     * @param t the input object to be encoded
     * @return the encoded representation of the input object
     */
    R encode(final T t);

    /**
     * Decodes an object of type T into a representation of type R.
     *
     * @param t the input object to be decoded
     * @return the decoded representation of the input object
     */
    R decode(final T t);
}
