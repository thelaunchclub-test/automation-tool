package com.twozo.commons.json.codec.encoder;

/**
 * Defines a method for encoding objects.
 * <p>
 * Converts objects of type T to a specific representation of
 * type R.
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface Encoder<T, R> {

    /**
     * Encodes an object of type T into a representation of type R.
     *
     * @param t the input object to be encoded
     * @return the encoded representation of the input object
     */
    R encode(final T t);
}

