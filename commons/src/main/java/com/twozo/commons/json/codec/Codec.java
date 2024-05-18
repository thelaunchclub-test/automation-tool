package com.twozo.commons.json.codec;

/**
 * <p>
 * Defines methods for encoding and decoding objects.
 * </p>
 *
 * <p>
 * Converts objects of type T to a specific representation
 * of type R and vice versa.
 * </p>
 *
 * @author petchimuthu
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
