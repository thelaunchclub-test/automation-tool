package com.twozo.commons.json.codec;

import com.twozo.commons.json.codec.decoder.Decoder;

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
 * @see Codec
 */
public final class CodecImpl<T, R> implements Codec<T, R> {

    private final Decoder<T, R> decoder;

    public CodecImpl(final Decoder<T, R> decoder) {
        this.decoder = decoder;
    }

    /**
     * {@inheritDoc}
     *
     * @param input the input object to be encoded
     * @return the encoded representation of the input object
     */
    @Override
    public R encode(final T input) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param input the input object to be decoded
     * @return the decoded representation of the input object
     */
    @Override
    public R decode(final T input) {
        return decoder.decode(input);
    }
}
